package com.robot.dao;

import com.robot.entity.Information;

import java.util.ArrayList;

/**
 * @author hua
 * @date 2018/9/24
 */
public interface InformationDao {

    Information findInformationInfo(int id);
    ArrayList<Information> findInformationTop();
    ArrayList<Information> findInformationByPage();
    Information findPolicyInfo(int id);
    ArrayList<Information> findPolicyTop();
    ArrayList<Information> findPolicyByPage();
    Information findHotspotInfo(int id);
    ArrayList<Information> findHotspotTop();
    ArrayList<Information> findHotspotByPage();
    Information findReportInfo(int id);
    ArrayList<Information> findReportTop();
    ArrayList<Information> findReportByPage();


}
