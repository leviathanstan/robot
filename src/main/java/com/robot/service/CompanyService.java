package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.CompanyDao;
import com.robot.entity.Area;
import com.robot.entity.Article;
import com.robot.entity.Company;

import com.robot.entity.RobotNews;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import org.aspectj.weaver.ArrayReferenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Ning
 * @date 2018/9/22
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;


    public String getCompanyBrand() {
        ArrayList<Company> companyList = (ArrayList<Company>) companyDao.getCompanyBrand();
        return GsonUtil.getSuccessJson(companyList);
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

    public String getCompanyNews() {
        return GsonUtil.getSuccessJson(companyDao.getCompanyNews());
    }


    public ArrayList<RobotNews> getIndexMemberNews() {
        return companyDao.getIndexMemberNews();
    }

    public String getMemberNewsInfo(Integer memberId) {
        RobotNews memberNews = companyDao.getMemberNewsInfo(memberId);
        if(memberNews==null)
            return GsonUtil.getErrorJson();
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
