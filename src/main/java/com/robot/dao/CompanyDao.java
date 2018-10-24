package com.robot.dao;

import com.robot.entity.*;

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

    ArrayList<RobotNews> getCompanyNews();

    Integer findCompanyById(Integer companyId);

    Integer getCompanyIdByName(String companyName);

    ArrayList<RobotNews> getIndexMemberNews();

    RobotNews getMemberNewsInfo(Integer memberId);

    ArrayList<RobotNews> getMemberNewsList();

    ArrayList<RobotNews> getIndexMemberDynamic();
}
