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

    ArrayList<RobotNews> getCompanyNews();

    ArrayList<RobotNews> getCompanyNewsList();

    RobotNews getCompanyNewsInfo(Integer newsId);

    ArrayList<RobotNews> getCompanyDynamics();

    ArrayList<RobotNews> getCompanyDynamicsList();

    RobotNews getCompanyDynamicsInfo(Integer newsId);


    ArrayList<Area> getCompanyArea();

    List<Company> getSpecifiedBrand(int specifiedId);

    Company getCompanyInfo(Integer companyId);

    Integer findCompanyById(Integer companyId);

    ArrayList<RobotNews> getIndexMemberNews();

    RobotNews getMemberNewsInfo(Integer memberId);

    ArrayList<RobotNews> getMemberNewsList();



}
