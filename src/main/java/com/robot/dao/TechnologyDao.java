package com.robot.dao;

import com.robot.entity.RobotNews;

import java.util.ArrayList;

/**
 * @author asce
 * @date 2018/10/23
 */
public interface TechnologyDao {

    ArrayList<RobotNews> getIndexBasic();
    ArrayList<RobotNews> getIndexCase();
    ArrayList<RobotNews> getIndexScience();
}
