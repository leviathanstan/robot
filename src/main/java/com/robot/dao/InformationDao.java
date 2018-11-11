package com.robot.dao;

import java.util.ArrayList;
import com.robot.entity.RobotNews;

import java.util.Map;

/**
 * @author hua
 * @date 2018/9/24
 */
public interface InformationDao {

    RobotNews findInformationInfo(int id);
    ArrayList<RobotNews> getInformationList(int categoryId);
    ArrayList<RobotNews> getIndexInformation(Map<String,Integer> map);
    ArrayList<RobotNews> getIndexCover(Map<String,Integer> map);

}
