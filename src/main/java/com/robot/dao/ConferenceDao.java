package com.robot.dao;

import com.robot.entity.Conference;
import com.robot.entity.RegistrationForm;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ning
 * @date 2018/9/22
 */
public interface ConferenceDao {

    ArrayList<Conference> getIndexConference(int type);
    ArrayList<Conference> getConferenceList(int type);
    Conference getInfo(int id);
    ArrayList<Conference> getHoldingConference();
    ArrayList<Conference> getPassConference();
    int addForm(RegistrationForm form);
    int addConference(Conference conference);
    int updateConference(Conference conference);
    int deleteConference(int id);
    ArrayList<Conference> findConference(HashMap<String,Object> args);
    ArrayList<Conference> findConferenceHadHold(HashMap<String,Object> args);
    ArrayList<Conference> findConferenceHadNotHold(HashMap<String,Object> args);
}
