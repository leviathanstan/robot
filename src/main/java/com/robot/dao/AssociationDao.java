package com.robot.dao;

import com.robot.entity.RobotNews;

import java.util.ArrayList;

import com.robot.entity.Member;

import java.util.Map;

/**
 * @author Ning
 * @date 2018/10/11
 */
public interface AssociationDao {

    RobotNews getRobotNewsInf(String id);

    ArrayList<RobotNews> getRobotNewsTop();

    ArrayList<RobotNews> findNews(Map<String,String> args);

    ArrayList<Member> getIndexMember();

    ArrayList<Member> findMember();

    Member getMemberInfo(Integer id);

    ArrayList<RobotNews> getNotice();

    ArrayList<RobotNews> findNotice(Map<String,String> args);

    RobotNews getNoticeInfo(String id);

    String getRobotContent(String id);
}
