package com.robot.dao;

import java.util.ArrayList;

import com.robot.entity.RobotNews;

import java.util.HashMap;
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
    ArrayList<RobotNews> find(HashMap<String,Object> args);
    int searchCount(String content);
    int searchCategoryCount(HashMap<String,Object> args);
    int delete(int id);
    int add(RobotNews robotNews);
    int addContent(HashMap map);
    int update(RobotNews robotNews );
    String findInformationById(int id);

}
