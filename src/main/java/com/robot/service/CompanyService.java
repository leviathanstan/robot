package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.CompanyDao;
import com.robot.entity.Area;
import com.robot.entity.Company;

import com.robot.entity.RobotNews;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * @author Ning
 * @date 2018/9/22
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;




    /**
     * 企业新闻(首页)
     */
    public ArrayList<RobotNews> getCompanyNews() {
        ArrayList<RobotNews> companyNews = companyDao.getCompanyNews();
        for(RobotNews robotNews : companyNews){
            robotNews.setPostDate(CommonUtil.getDate(robotNews.getPostDate()));
        }
        return companyNews;
    }

    /**
     *企业新闻
     */
    public String getCompanyNewsList(Integer pageNum) {
        int page = CommonUtil.formatPageNum((String.valueOf(pageNum)));
        PageHelper.startPage(page,Constant.PRODUCT_PAGE_COUNT);
        ArrayList<RobotNews> companyNewsList = companyDao.getCompanyNewsList();
        for(RobotNews robotNews : companyNewsList){
            robotNews.setPostDate(CommonUtil.getDate(robotNews.getPostDate()));
        }
        PageInfo<RobotNews> pageInfo = new PageInfo<>(companyNewsList);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 品牌展厅(首页)
     */
    public ArrayList<Company> getCompanyBrand() {
        ArrayList<Company> companyList = companyDao.getCompanyBrand();
        return companyList;
    }

    /**
     * 会员动态(首页)
     */
    public ArrayList<RobotNews> getCompanyDynamics() {
        ArrayList<RobotNews> companyNews = companyDao.getCompanyDynamics();
        for(RobotNews robotNews : companyNews){
            robotNews.setPostDate(CommonUtil.getDate(robotNews.getPostDate()));
        }
        return companyNews;
    }

    /**
     * 会员动态
     */
    public String getCompanyDynamicsList(Integer pageNum) {
        int page = CommonUtil.formatPageNum((String.valueOf(pageNum)));
        PageHelper.startPage(page,Constant.PRODUCT_PAGE_COUNT);
        ArrayList<RobotNews> companyNewsList = companyDao.getCompanyDynamicsList();
        for(RobotNews robotNews : companyNewsList){
            robotNews.setPostDate(CommonUtil.getDate(robotNews.getPostDate()));
        }
        PageInfo<RobotNews> pageInfo = new PageInfo<>(companyNewsList);
        return GsonUtil.getSuccessJson(pageInfo);
    }


    public String getCompanyNewsInfo(Integer newsId) {
        RobotNews companyNews = companyDao.getCompanyNewsInfo(newsId);
        if(companyNews == null){
            return GsonUtil.getErrorJson();
        }else{
            return GsonUtil.getSuccessJson(companyNews);
        }
    }

    public String getCompanyDynamicsInfo(Integer newsId) {
        RobotNews companyNews = companyDao.getCompanyDynamicsInfo(newsId);
        if(companyNews == null){
            return GsonUtil.getErrorJson();
        }else{
            return GsonUtil.getSuccessJson(companyNews);
        }
    }

    public String getCompanyArea() {
        ArrayList<Area> areaList = companyDao.getCompanyArea();
        return GsonUtil.getSuccessJson(areaList);
    }

    public String getSpecifiedBrand(Integer specifiedId) {
        ArrayList<Company> companyList = (ArrayList<Company>) companyDao.getSpecifiedBrand(specifiedId);
        return GsonUtil.getSuccessJson(companyList);
    }

    public String getCompanyInfo(Integer companyId) {
        if(companyDao.findCompanyById(companyId) == 1){
            return GsonUtil.getSuccessJson((companyDao.getCompanyInfo(companyId)));
        }else {
            return GsonUtil.getErrorJson();
        }

    }

    public ArrayList<RobotNews> getIndexMemberNews() {
        return companyDao.getIndexMemberNews();
    }

    public String getMemberNewsInfo(Integer memberId) {
        RobotNews memberNews = companyDao.getMemberNewsInfo(memberId);
        if(memberNews==null)
            return GsonUtil.getErrorJson();
        memberNews.setContent(CommonUtil.getAbsolutePath(memberNews.getContent()));
        return GsonUtil.getSuccessJson(memberNews);
    }

    public String getMemberNewsList(Integer pageNum) {
        int page = CommonUtil.formatPageNum((String.valueOf(pageNum)));
        PageHelper.startPage(page,Constant.PRODUCT_PAGE_COUNT);
        ArrayList<RobotNews> robotNewsList = companyDao.getMemberNewsList();
        PageInfo<RobotNews> pageInfo = new PageInfo<>(robotNewsList);
        return GsonUtil.getSuccessJson(pageInfo);
    }



}
