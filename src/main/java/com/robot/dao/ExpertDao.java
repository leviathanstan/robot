package com.robot.dao;

import com.robot.entity.Expert;
import com.robot.entity.RobotNews;
import com.robot.entity.University;

import java.util.ArrayList;

/**
 * @author hua
 * @date 2018/9/25
 */
public interface ExpertDao {

     Expert findExpertInf(int id);
     University findUniversityInf(int id);
     ArrayList<RobotNews> findExpertArtTop();
     ArrayList<Expert> findAllExpert();
     ArrayList<University> findAllUniversity();
     RobotNews findExpertArtInf(int id);
     ArrayList<RobotNews> findExpertArtByPage();
}
