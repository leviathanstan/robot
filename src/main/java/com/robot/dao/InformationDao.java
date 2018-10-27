package com.robot.dao;

import com.robot.entity.RobotNews;

import java.util.ArrayList;

/**
 * @author hua
 * @date 2018/9/24
 */
public interface InformationDao {

    RobotNews findInformationInfo(int id);
    ArrayList<RobotNews> findInformationTop();
    ArrayList<RobotNews> findInformationByPage();
    RobotNews findPolicyInfo(int id);
    ArrayList<RobotNews> findPolicyTop();
    ArrayList<RobotNews> findPolicyByPage();
    RobotNews findHotspotInfo(int id);
    ArrayList<RobotNews> findHotspotTop();
    ArrayList<RobotNews> findHotspotByPage();
    RobotNews findReportInfo(int id);
    ArrayList<RobotNews> findReportTop();
    ArrayList<RobotNews> findReportByPage();
    String findInfContent(String id);
    String findPolContent(String id);

}
