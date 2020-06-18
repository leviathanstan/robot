package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.BiddingDao;
import com.robot.dao.DemandDao;
import com.robot.entity.*;
import com.robot.util.Constant;
import com.robot.util.FileUtil;
import com.robot.util.GsonUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * create by 聪 on 2018/1/22
 */
@Service
public class DemandService {

    private static final int PAGE_LENGTH = 15;

    //供应
    private static final int PROVIDE_TYPE = 0;

    //需求
    private static final int DEMAND_TYPE = 1;

    @Autowired
    private DemandDao demandDao;

    @Autowired
    private BiddingDao biddingDao;


    /**
     * 分页获取需求或供应
     * @Author  xm
     * @Date 2020/4/1 21:27
     * @param type
     * @param pageNum
     * @param keyword
     * @param userId
     * @return java.lang.String
     */
    public String getDemands(int type, int pageNum, String keyword, Integer userId){
        DemandExample example = new DemandExample();
        DemandExample.Criteria criteria = example.createCriteria();

        //设置搜索的关键字
        example.setKeyword(keyword);

        //如果userId不为空则是获取我的需求
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }

        criteria.andTypeEqualTo(type);
        example.setOrderByClause("creat_time");

        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<Demand> demands = demandDao.selectByExample(example);
        PageInfo<Demand> pageInfo = new PageInfo<>(demands);

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Demand.class,"content","userId","type"), pageInfo);
    }

    /**
     * 获取首页的供需
     * @Author  xm
     * @Date 2020/6/8 12:05
     * @param type
     * @return java.util.List<com.robot.entity.Demand>
     */
    public List<Demand> getIndexDemands(int type){
        DemandExample example = new DemandExample();
        DemandExample.Criteria criteria = example.createCriteria();

        criteria.andTypeEqualTo(type);
        example.setOrderByClause("creat_time");

        PageHelper.startPage(1, 10);

        return demandDao.selectByExample(example);
    }

    public String getDemand(int id){
        Demand demand = demandDao.selectByPrimaryKey(id);
        return GsonUtil.getSuccessJson(demand);
    }

    public String saveDemand(Demand demand) {
        if (demand.getTitle() == null || "".equals(demand.getTitle())) {
            return GsonUtil.getErrorJson("标题不能为空！");
        }
        if (demand.getContent() == null || "".equals(demand.getContent())) {
            return GsonUtil.getErrorJson("内容不能为空！");
        }
        if (demand.getContact() == null || "".equals(demand.getContact())) {
            return GsonUtil.getErrorJson("联系方式不能为空！");
        }
        if (demand.getDeadline() == null) {
            return GsonUtil.getErrorJson("截止时间不能为空！");
        }
        if (demand.getEnterprise() == null || "".equals(demand.getEnterprise())) {
            return GsonUtil.getErrorJson("公司名称不能为空！");
        }
        if (demand.getContactPeople() == null || "".equals(demand.getContactPeople())) {
            return GsonUtil.getErrorJson("联系人不能为空！");
        }
        if (demand.getType() == null || (demand.getType() != PROVIDE_TYPE && demand.getType() != DEMAND_TYPE) ) {
            return GsonUtil.getErrorJson("供需类型不正确！");
        }
        demandDao.insertSelective(demand);
        return GsonUtil.getSuccessJson(demand.getId());
    }

    /**
     * 修改供需
     * @Author  xm
     * @Date 2020/6/18 15:53
     * @param demand
     * @param session
     * @return java.lang.String
     */
    public String updateDemand(Demand demand, HttpSession session) {
        User user = (User) session.getAttribute("user");
        DemandExample example = new DemandExample();
        example.createCriteria().andIdEqualTo(demand.getId()).andUserIdEqualTo(user.getId());

        demand.setId(null);
        demand.setUserId(null);
        demand.setType(null);
        demand.setCreatTime(null);
        if (1 == demandDao.updateByExampleSelective(demand, example)) {
            return GsonUtil.getSuccessJson("修改成功");
        } else {
            return GsonUtil.getErrorJson("修改失败");
        }
    }

    /**
     * 删除供需
     * @Author  xm
     * @Date 2020/6/18 16:09 
     * @param session	
 * @param ids	
     * @return java.lang.String
     */
    public String deleteDemand(HttpSession session, List<Integer> ids) {
        User user = (User) session.getAttribute("user");
        for (Integer id : ids) {
            DemandExample example = new DemandExample();
            example.createCriteria().andIdEqualTo(id).andUserIdEqualTo(user.getId());
            if (demandDao.deleteByExample(example) != 1) {
                return GsonUtil.getErrorJson("删除失败");
            }
        }
        return GsonUtil.getSuccessJson("删除成功");
    }

    /**
     * 投标
     * @Author  xm
     * @Date 2020/4/2 16:03
     * @param bidding
     * @param attachment
     * @return java.lang.String
     */
    public String bid(Bidding bidding, MultipartFile attachment){
        if (bidding.getContact() == null || "".equals(bidding.getContact())) {
            return GsonUtil.getErrorJson("联系电话不能为空");
        }
        if (bidding.getContactPeople() == null || "".equals(bidding.getContactPeople())) {
            return GsonUtil.getErrorJson("联系人不能为空");
        }
        if (bidding.getDescription() == null || "".equals(bidding.getDescription())) {
            return GsonUtil.getErrorJson("相关描述不能为空");
        }
        if (bidding.getDemandId() == null) {
            return GsonUtil.getErrorJson("需求id不能为空");
        }

        //判断是否到了截止时间
        Demand demand = demandDao.selectByPrimaryKey(bidding.getDemandId());
        if (demand == null) {
            return GsonUtil.getErrorJson("投标失败，无该需求");
        }
        if (demand == null || new Date().after(demand.getDeadline())) {
            return GsonUtil.getErrorJson("投标失败，已经过了截止时间");
        }

        String fileName = attachment.getOriginalFilename();
        if (!fileName.endsWith(".zip")) {
            return GsonUtil.getErrorJson("只支持zip格式");
        }

        //生成文件名
        String fileNameByMD5 = FileUtil.getFileHash(fileName);
        //保存文件
        FileUtil.zipUpload(fileNameByMD5, attachment, Constant.BIDDING_ATTACHMENT_PATH);

        bidding.setAttachmentUrl(fileNameByMD5);

        if (biddingDao.insertSelective(bidding) != 1) {
            return GsonUtil.getErrorJson("投标失败");
        }

        return GsonUtil.getSuccessJson(bidding.getId());
    }

    /**
     * 发布需求的人看投标信息
     * @Author  xm
     * @Date 2020/4/2 16:47
     * @param userId
     * @param pageNum
     * @param demandId
     * @return java.lang.String
     */
    public String getBid(Integer userId, Integer pageNum, Integer demandId) {
        BiddingExample example = new BiddingExample();
        BiddingExample.Criteria criteria = example.createCriteria();

        //如果需求id为空
        if (demandId == null) {
            //获取当前用户发布的需求
            List<Integer> ids = demandDao.selectUserDemand(userId);
            if (ids.isEmpty()) {
                return GsonUtil.getErrorJson("无投标信息");
            }
            criteria.andDemandIdIn(ids);
        } else {
            //判断该需求是不是当前用户发的
            Demand demand = demandDao.selectByPrimaryKey(demandId);
            if (demand == null || !demand.getUserId().equals(userId)) {
                return GsonUtil.getErrorJson("无投标信息");
            }
            criteria.andDemandIdEqualTo(demandId);
        }

        example.setOrderByClause("time");

        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<Bidding> biddings = biddingDao.selectByExample(example);
        PageInfo<Bidding> pageInfo = new PageInfo<>(biddings);

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Bidding.class,"attachmentUrl","demandId"), pageInfo);
    }

    /**
     * 下载投标信息的附件
     * @Author  xm
     * @Date 2020/4/2 19:17
     * @param userId
     * @param id
     * @return org.springframework.http.ResponseEntity<byte[]>
     */
    public ResponseEntity<byte[]> dowmloadAttachment(Integer userId, Integer id) throws IOException {
        //获取投标信息
        Bidding bidding = biddingDao.selectByPrimaryKey(id);
        if (bidding == null) {
            return null;
        }
        //获取需求信息进行判断当前用户是否可以下载附件
        Demand demand = demandDao.selectByPrimaryKey(bidding.getDemandId());
        if (!demand.getUserId().equals(userId)) {
            return null;
        }

        File file = new File(Constant.BIDDING_ATTACHMENT_PATH + bidding.getAttachmentUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", bidding.getAttachmentUrl());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
