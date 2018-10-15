package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.AssociationDao;
import com.robot.entity.Notice;
import com.robot.entity.RobotNews;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import com.robot.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ning
 * @date 2018/10/11
 */
@Service
public class AssociationService {
    @Autowired
    private AssociationDao associationDao;

    /**
     * 获取协会新闻详细信息
     * @author hua
     * @date 2018/10/11
     * @param urlId
     * @return
     */
    public String getRobotNewsInf(String urlId){
        RobotNews robotNews = associationDao.getRobotNewsInf(urlId);
        if(robotNews != null)
            return GsonUtil.getSuccessJson(robotNews);
        else
            return GsonUtil.getErrorJson();
    }

    /**
     * 获取协会新闻最新九条
     * @return
     */
    public List<RobotNews> getIndexNews(){
        return associationDao.getRobotNewsTop();
    }

    /**
     * 首页协会成员
     * @return
     */
    public String getAssociationMember() {
        return GsonUtil.getSuccessJson(associationDao.getAssociationMember());
    }

    public String getAllMember() {
        ArrayList<Member> memberArrayList = associationDao.getAllMember();
        return GsonUtil.getSuccessJson(memberArrayList);
    }

    /**
     * 首页公告
     * @return
     */
    public List<Notice> getIndexNotice(){
        return associationDao.getNotice();
    }
    /**
     * 搜索公告
     * @author asce
     * @date 2018/10/12
     * @param args 搜索参数
     * @return
     */
    public String getNotice(Map<String,String> args){
        if (args==null)
            return GsonUtil.getErrorJson();
        int pageNum = CommonUtil.formatPageNum(args.get("pageNum"));
        PageHelper.startPage(pageNum,Constant.PRODUCT_PAGE_COUNT);
        List<Notice> notices = associationDao.findNotice(args);
        PageInfo<Notice> pageInfo = new PageInfo<>(notices);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    public String getNoticeInfo(String id){
        Notice notice = associationDao.getNoticeInfo(id);
        if(notice==null)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson(notice);
    }
}
