package com.robot.dao;

import com.robot.entity.Conference;

import java.util.ArrayList;

/**
 * @author Ning
 * @date 2018/9/22
 */
public interface ConferenceDao {

    ArrayList<Conference> getHoldingConference();

    ArrayList<Conference> getPassConference();

    ArrayList<Conference> getHoldingMeeting();

    ArrayList<Conference> getPassMeeting();
}
