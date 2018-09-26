package com.robot.dao;

import com.robot.entity.Expert;
import com.robot.entity.University;

/**
 * @author hua
 * @date 2018/9/25
 */
public interface ExpertDao {

     Expert findExpertInf(int id);
     University findUniversityInf(int id);
}
