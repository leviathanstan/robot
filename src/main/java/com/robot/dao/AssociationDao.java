package com.robot.dao;

import com.robot.entity.RobotNews;

import java.util.ArrayList;

import com.robot.entity.Member;

import java.util.ArrayList;

/**
 * @author Ning
 * @date 2018/10/11
 */
public interface AssociationDao {

    RobotNews getRobotNewsInf(String urlId);
    ArrayList<RobotNews> getRobotNewsTop();

    ArrayList<Member> getAssociationMember();

    ArrayList<Member> getAllMember();
}
