package com.robot.service;

import com.robot.dao.ConferenceDao;
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
//        String usernameRegularExpression = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
//        String phoneRegularExpression = "^[0-9]{0,12}$";
//        String userWechatRegularExpression = "^[a-zA-Z0-9\u4E00-\u9FA5]{3,10}$";
//        String userCompanyNameRegularExpression = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
//        String addressRegularExpression = "^[a-zA-Z0-9\u4E00-\u9FA5]{0,20}$";
//        String userPositionRegularExpression = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
//        String emailRegularExpression = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
//
//        Msg msg = new Msg();
//
//        if("".equals(registrationForm.getName()) || registrationForm.getName() == null){
//            msg.setResult("姓名不能为空");
//            msg.setMessage(registrationForm);
//            return GsonUtil.getErrorJson(msg);
//        }else if(!(registrationForm.getName().matches(usernameRegularExpression))){
//            msg.setResult("姓名格式出错");
//            msg.setMessage(registrationForm);
//            return GsonUtil.getErrorJson(msg);
//        }else if(){
//
//        }
//        return null;
//    }
}
