package com.robot.service;

import com.robot.dao.CompanyDao;
import com.robot.entity.Area;
import com.robot.entity.Company;

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
     * 品牌展厅(首页)
     */
    public ArrayList<Company> getCompanyBrand() {
        ArrayList<Company> companyList = companyDao.getCompanyBrand();
        return companyList;
    }

//    public String getCompanyArea() {
//        ArrayList<Area> areaList = companyDao.getCompanyArea();
//        return GsonUtil.getSuccessJson(areaList);
//    }
//
//    public String getSpecifiedBrand(Integer specifiedId) {
//        ArrayList<Company> companyList = (ArrayList<Company>) companyDao.getSpecifiedBrand(specifiedId);
//        return GsonUtil.getSuccessJson(companyList);
//    }

}
