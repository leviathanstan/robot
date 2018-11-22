package com.robot.service;

import com.robot.bean.Msg;
import com.robot.dao.CompanyDao;
import com.robot.dao.ConferenceDao;
import com.robot.entity.Conference;
import com.robot.entity.RegistrationForm;
import com.robot.entity.User;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;

/**
 * @author Ning
 * @date 2018/9/27
 */
@Service
public class ConferenceService {

    @Autowired
    private ConferenceDao conferenceDao;

    private final int PAGE_LENGTH = 15;
    /**
     * 首页会议
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public ArrayList<Conference> getIndexConference(){
        ArrayList<Conference> conferences = conferenceDao.getIndexConference(0);
        return conferences;
    }
    /**
     * 首页展会
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public ArrayList<Conference> getIndexMetting(){
        ArrayList<Conference> conferences = conferenceDao.getIndexConference(1);
        return conferences;
    }
    /**
     * 展会列表
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public String getConferenceList(String page){
        int pageNum = CommonUtil.formatPageNum(page);
        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<Conference> conferences = conferenceDao.getConferenceList(0);
        PageInfo<Conference> pageInfo = new PageInfo<>(conferences);
        return GsonUtil.getSuccessJson(pageInfo);
    }
    /**
     * 展会列表
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public String getMettingList(String page){
        int pageNum = CommonUtil.formatPageNum(page);
        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<Conference> conferences = conferenceDao.getConferenceList(1);
        PageInfo<Conference> pageInfo = new PageInfo<>(conferences);
        return GsonUtil.getSuccessJson(pageInfo);
    }
    /**
     * 即将举办
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public String getHoldingConferences(){
        ArrayList<Conference> conferences = conferenceDao.getHoldingConference();
        return GsonUtil.getSuccessJson(conferences);
    }
    /**
     * 往期会议
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public String getPassConference(){
        ArrayList<Conference> conferences = conferenceDao.getPassConference();
        return GsonUtil.getSuccessJson(conferences);
    }
    /**
     * 增加会议
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public String addConference(Conference conference, HttpSession session){
        User user = (User) session.getAttribute("user");
        conference.setUserId(user.getId());
        if (conferenceDao.addConference(conference)!=1){
            return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson();
    }
    /**
     * 更新会议
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public String updateConference(Conference conference,HttpSession session){
        Conference dbConference = conferenceDao.getInfo(conference.getId());
        User user = (User) session.getAttribute("user");
        if (dbConference.getUserId()!=user.getId()){
            return GsonUtil.getErrorJson();
        }
        if (conferenceDao.updateConference(conference)!=1){
            return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson();
    }
    /**
     * 删除会议
     * @author asce
     * @date 2018/11/22
     * @param
     * @return
     */
    public String deleteConference(int id,HttpSession session){
        Conference dbConferences = conferenceDao.getInfo(id);
        User user = (User) session.getAttribute("user");
        if(dbConferences.getUserId()!=user.getId()){
            if ((int)session.getAttribute("rank")!=1){
                return GsonUtil.getErrorJson();
            }
        }
        if(conferenceDao.deleteConference(id)!=1){
            return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson();
    }

    /***
     * 报名
     * @param registrationForm
     * @return
     */
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
//        } else if (conferenceDao.findEnrollByName(registrationForm.getName()) == 1) {
//            msg.setResult("您已报名过该活动");
//            msg.setMessage(registrationForm);
//            return GsonUtil.getErrorJson(msg);
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
            conferenceDao.addForm(registrationForm);
            return GsonUtil.getSuccessJson("成功提交");
        }
    }
}
