package com.robot.service;

import com.robot.dao.ConferenceDao;
import com.robot.entity.RegistrationForm;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ning
 * @date 2018/9/27
 */
@Service
public class ConferenceService {

    @Autowired
    private ConferenceDao conferenceDao;


    public String getRelevantConference(Integer relevantId) {
        if(relevantId == null){
            return GsonUtil.getErrorJson();
        }else if(relevantId == 0){
            return GsonUtil.getSuccessJson(conferenceDao.getHoldingConference());
        }else if(relevantId == -1){
            return GsonUtil.getSuccessJson(conferenceDao.getPassConference());
        }else if(relevantId == 1){

        }
        return null;
    }

    public String getRelevantMeting(Integer relevantId) {
        if(relevantId == null){
            return GsonUtil.getErrorJson();
        }else if(relevantId == 0){
            return GsonUtil.getSuccessJson(conferenceDao.getHoldingMeeting());
        }else if(relevantId == -1){
            return GsonUtil.getSuccessJson(conferenceDao.getPassMeeting());
        }else if(relevantId == 1){

        }
        return null;
    }

//    public String enroll(RegistrationForm registrationForm) {
//        return null;
//    }
}
