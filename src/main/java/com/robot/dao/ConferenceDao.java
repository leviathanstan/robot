package com.robot.dao;

import com.robot.entity.Conference;
import com.robot.entity.RegistrationForm;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ning
 * @date 2018/9/22
 */
public interface ConferenceDao {

    ArrayList<Conference> getIndexConference(int type);
    ArrayList<Conference> getConferenceList(int type);
    Conference getInfo(int id);
    ArrayList<Conference> getHoldingConference(int type);
    ArrayList<Conference> getPassConference(int type);
    int addForm(RegistrationForm form);
    int addConference(Conference conference);
    int updateConference(Conference conference);
    int deleteConference(int id);
    ArrayList<Conference> findConference(HashMap<String,Object> args);
    ArrayList<Conference> findConferenceHadHold(HashMap<String,Object> args);
    ArrayList<Conference> findConferenceHadNotHold(HashMap<String,Object> args);
    List<Integer> selectMemberConference(int userId);
    void deleteMemberConference(int id);
    void insertMemberConference(@Param("conferenceId")int conferenceId, @Param("userId")int userId);
}
