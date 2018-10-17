package com.robot.dao;

import com.robot.entity.Notice;
import com.robot.entity.RobotNews;

import java.util.ArrayList;

import com.robot.entity.Member;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Ning
 * @date 2018/10/11
 */
public interface AssociationDao {

    RobotNews getRobotNewsInf(String id);
    ArrayList<RobotNews> getRobotNewsTop();
    ArrayList<RobotNews> findNews(Map<String,String> args);

    ArrayList<Member> getMember();
    ArrayList<Member> findMember();
    Member getMemberInfo(String id);

    ArrayList<Notice> getNotice();
    ArrayList<Notice> findNotice(Map<String,String> args);
    Notice getNoticeInfo(String id);

}
