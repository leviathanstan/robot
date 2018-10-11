package com.robot.dao;

import com.robot.entity.Member;

import java.util.ArrayList;

/**
 * @author Ning
 * @date 2018/10/11
 */
public interface AssociationDao {

    ArrayList<Member> getAssociationMember();
}
