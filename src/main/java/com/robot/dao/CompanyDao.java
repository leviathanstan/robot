package com.robot.dao;

import com.robot.entity.Area;
import com.robot.entity.Article;
import com.robot.entity.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ning
 * @date 2018/9/22
 */
public interface CompanyDao {

    List<Company> getCompanyBrand();

    ArrayList<Area> getCompanyArea();

    List<Company> getSpecifiedBrand(int specifiedId);

    Company getCompanyInfo(Integer companyId);

    ArrayList<Article> getCompanyNews();
}
