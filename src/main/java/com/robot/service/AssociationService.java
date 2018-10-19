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
     *  搜索新闻
     * @param args
     * @return
     */
    public String getNewsList(Map<String,String> args){
        if (args==null)
            return GsonUtil.getErrorJson();
        int pageNum = CommonUtil.formatPageNum(args.get("pageNum"));
        PageHelper.startPage(pageNum,Constant.PRODUCT_PAGE_COUNT);
        List<RobotNews> news = associationDao.findNews(args);
        PageInfo<RobotNews> pageInfo = new PageInfo<>(news);
        for (RobotNews news1:news){
            news1.setContent(CommonUtil.getPreview(news1.getContent()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
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
     */
    public String getIndexMember() {
        return GsonUtil.getSuccessJson(associationDao.getIndexMember());
    }

    /**
     * 分页获得成员信息
     */
    public String getMemberList(Integer pageNum) {
        int page = CommonUtil.formatPageNum((String.valueOf(pageNum)));
        PageHelper.startPage(page,Constant.PRODUCT_PAGE_COUNT);
        List<Member> members = associationDao.findMember();
        PageInfo<Member> pageInfo = new PageInfo<>(members);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 获得具体成员信息
     */
    public String getMemberInfo(Integer id){
        Member member = associationDao.getMemberInfo(id);
        if(member==null)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson(member);
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
        for(Notice notice:notices){
            notice.setContent(CommonUtil.getPreview(notice.getContent()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 公告详细信息
     * @param id
     * @return
     */
    public String getNoticeInfo(String id){
        Notice notice = associationDao.getNoticeInfo(id);
        if(notice==null)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson(notice);
    }
}
