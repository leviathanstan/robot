package com.robot.dao;

import com.robot.entity.Technology;

import java.util.ArrayList;

/**
 * @author asce
 * @date 2018/10/23
 */
public interface TechnologyDao {

    ArrayList<Technology> getIndexBasic();
    ArrayList<Technology> getIndexCase();
    ArrayList<Technology> getIndexScience();
}
