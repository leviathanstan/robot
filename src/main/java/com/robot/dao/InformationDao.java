package com.robot.dao;

<<<<<<< HEAD
import com.robot.entity.Information;

import java.util.ArrayList;
=======
import com.robot.entity.RobotNews;

import java.util.ArrayList;
import java.util.Map;
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc

/**
 * @author hua
 * @date 2018/9/24
 */
public interface InformationDao {

<<<<<<< HEAD
    Information findInformationInfo(int id);
    ArrayList<Information> findInformationTop(Integer id);
    ArrayList<Information> findInformationByPage(Integer categoryId);
    ArrayList<Information> findInformation1Top();
    ArrayList<Information> findInformation1ByPage();
=======
    RobotNews findInformationInfo(int id);
    ArrayList<RobotNews> getInformationList(int categoryId);
    ArrayList<RobotNews> getIndexInformation(Map<String,Integer> map);
    ArrayList<RobotNews> getIndexCover(Map<String,Integer> map);


>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
}
