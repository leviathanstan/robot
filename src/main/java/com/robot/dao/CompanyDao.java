package com.robot.dao;

import com.robot.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ning
 * @date 2018/9/22
 */
public interface CompanyDao {

    ArrayList<Company> getCompanyBrand();

    ArrayList<Area> getCompanyArea();

    List<Company> getSpecifiedBrand(int specifiedId);

    Company getCompanyInfo(Integer companyId);

    Integer findCompanyById(Integer companyId);

}
