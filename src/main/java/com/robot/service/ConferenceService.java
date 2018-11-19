package com.robot.service;

import com.robot.bean.Msg;
import com.robot.dao.CompanyDao;
import com.robot.dao.ConferenceDao;
import com.robot.entity.RegistrationForm;
import com.robot.util.Constant;
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

    @Autowired
    private CompanyDao companyDao;

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

    public String enroll(RegistrationForm registrationForm) {

        Msg msg = new Msg();

        if ("".equals(registrationForm.getName()) || registrationForm.getName() == null) {
            msg.setResult("姓名不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getName().matches(Constant.USERNAMEREGULAREXPRESSION))) {
            msg.setResult("姓名格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (conferenceDao.findEnrollByName(registrationForm.getName()) == 1) {
            msg.setResult("您已报名过该活动");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getGender()) || registrationForm.getGender() == null) {
            msg.setResult("性别不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!("男".equals(registrationForm.getGender()) && !("女".equals(registrationForm.getGender())))) {
            msg.setResult("性别格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getPhone()) || registrationForm.getPhone() == null) {
            msg.setResult("手机号码不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getPhone().matches(Constant.PHONEREGULAREXPRESSION))) {
            msg.setResult("手机号码格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getWeChat()) || registrationForm.getWeChat() == null) {
            msg.setResult("微信号不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getWeChat().matches(Constant.USERWECHATREGULAREXPRESSION))) {
            msg.setResult("微信号格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getCompanyName()) || registrationForm.getCompanyName() == null) {
            msg.setResult("公司名不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getCompanyName().matches(Constant.USERCOMPANYNAMEREGULAREXPRESSION))) {
            msg.setResult("公司名格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getCompanyName()) || registrationForm.getCompanyName() == null) {
            msg.setResult("公司名不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getCompanyName().matches(Constant.USERCOMPANYNAMEREGULAREXPRESSION))) {
            msg.setResult("公司名格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getCompanyAddress()) || registrationForm.getCompanyAddress() == null) {
            msg.setResult("公司地址不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getCompanyAddress().matches(Constant.ADDRESSREGULAREXPRESSION))) {
            msg.setResult("公司地址格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getPosition()) || registrationForm.getPosition() == null) {
            msg.setResult("职位不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getPosition().matches(Constant.USERPOSITIONREGULAREXPRESSION))) {
            msg.setResult("职位格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getEmail()) || registrationForm.getEmail() == null) {
            msg.setResult("邮箱不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getEmail().matches(Constant.EMAILREGULAREXPRESSION))) {
            msg.setResult("邮箱格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else {
            conferenceDao.insertToEnroll(registrationForm);
            return GsonUtil.getSuccessJson("成功提交");
        }
    }
}
