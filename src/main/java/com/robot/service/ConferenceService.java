package com.robot.service;

import com.robot.bean.Msg;
import com.robot.dao.CompanyDao;
import com.robot.dao.ConferenceDao;
import com.robot.entity.Conference;
import com.robot.entity.RegistrationForm;
import com.robot.entity.RobotNews;
import com.robot.entity.User;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * @author Ning
 * @date 2018/9/27
 */
@Service
public class ConferenceService {

    @Autowired
    private ConferenceDao conferenceDao;

    private final int PAGE_LENGTH = 10;

    private enum ConferenceEnum{
        MEETING("1"),CONFERENCE("2");
        private final String type;
        ConferenceEnum(String type){
            this.type = type;
        }
        public String getType(){
            return type;
        }
    }

    /**
     * 首页会议
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public ArrayList<Conference> getIndexConference() {
        ArrayList<Conference> conferences = conferenceDao.getIndexConference(1);
        for(Conference conference :conferences)
            conference.setPostDate(CommonUtil.formateDbTime(conference.getPostDate()));
        return conferences;
    }

    /**
     * 首页展会
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public ArrayList<Conference> getIndexMetting() {
        ArrayList<Conference> conferences = conferenceDao.getIndexConference(2);
        for(Conference conference :conferences)
            conference.setPostDate(CommonUtil.formateDbTime(conference.getPostDate()));
        return conferences;
    }

    /**
     * 首页其他
     * @return
     */
    public List<Conference> getOther() {
        ArrayList<Conference> conferences1 = getIndexMetting();
        ArrayList<Conference> conferences2 = getIndexConference();
        List<Conference> conferences = new ArrayList<>();
        conferences.addAll(conferences1);
        conferences.addAll(conferences2);
        return conferences;
    }

    /**
     * 展会列表
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public String getConferenceList(String page) {
        HashMap<String,String> map = new HashMap();
        map.put("pageNum",page);
        map.put("categoryId",ConferenceEnum.CONFERENCE.getType());
        map.put("timeType","1");
        return findConference(map);
    }

    /**
     * 会议列表
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public String getMeetingList(String page) {
        HashMap<String,String> map = new HashMap();
        map.put("pageNum",page);
        map.put("categoryId",ConferenceEnum.MEETING.getType());
        map.put("timeType","1");
        return findConference(map);
    }

    /**
     * 即将举办
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public String getHoldingConferences(String page) {
        HashMap<String,String> map = new HashMap();
        map.put("pageNum",page);
        map.put("categoryId",ConferenceEnum.CONFERENCE.getType());
        map.put("timeType","2");
        return findConference(map);
    }

    /**
     * 往期展会
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public String getPassConference(String page) {
        HashMap<String,String> map = new HashMap();
        map.put("pageNum",page);
        map.put("categoryId",ConferenceEnum.CONFERENCE.getType());
        map.put("timeType","3");
        return findConference(map);
    }

    /**
     * 即将举办
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public String getHoldingMeeting(String page) {
        HashMap<String,String> map = new HashMap();
        map.put("pageNum",page);
        map.put("categoryId",ConferenceEnum.MEETING.getType());
        map.put("timeType","2");
        return findConference(map);
    }

    /**
     * 往期会议
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public String getPassMeeting(String page) {
        HashMap<String,String> map = new HashMap();
        map.put("pageNum",page);
        map.put("categoryId",ConferenceEnum.MEETING.getType());
        map.put("timeType","3");
       return findConference(map);
    }

    /**
     * 增加会议
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    @Transactional
    public String addConference(Conference conference, HttpSession session) {
        User user = (User) session.getAttribute("user");
        conference.setUserId(user.getId());
        if (conferenceDao.addConference(conference) != 1) {
            return GsonUtil.getErrorJson();
        }
        int id = conference.getId();
        conferenceDao.insertMemberConference(id,user.getId());
        return GsonUtil.getSuccessJson();
    }

    /**
     * 更新会议
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    public String updateConference(Conference conference, HttpSession session) {
        Conference dbConference = conferenceDao.getInfo(conference.getId());
        User user = (User) session.getAttribute("user");
        if (dbConference.getUserId() != user.getId()) {
            return GsonUtil.getErrorJson();
        }
        if (conferenceDao.updateConference(conference) != 1) {
            return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 删除会议
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/22
     */
    @Transactional
    public String deleteConference(int id, HttpSession session) {
        conferenceDao.deleteMemberConference(id);
        if (conferenceDao.deleteConference(id) != 1) {
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
        } else if (!(registrationForm.getName().matches(Constant.USER_NAME_REGULAR_EXPRESSION))) {
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
        } else if (!(registrationForm.getPhone().matches(Constant.PHONE_REGULAR_EXPRESSION))) {
            msg.setResult("手机号码格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getWeChat()) || registrationForm.getWeChat() == null) {
            msg.setResult("微信号不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getWeChat().matches(Constant.USER_WECHAT_REGULAR_EXPRESSION))) {
            msg.setResult("微信号格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getCompanyName()) || registrationForm.getCompanyName() == null) {
            msg.setResult("公司名不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getCompanyName().matches(Constant.USER_COMPANY_NAME_REGULAR_EXPRESSION))) {
            msg.setResult("公司名格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getCompanyName()) || registrationForm.getCompanyName() == null) {
            msg.setResult("公司名不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getCompanyName().matches(Constant.ADDRESS_REGULAR_EXPRESSION))) {
            msg.setResult("公司名格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getCompanyAddress()) || registrationForm.getCompanyAddress() == null) {
            msg.setResult("公司地址不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getCompanyAddress().matches(Constant.ADDRESS_REGULAR_EXPRESSION))) {
            msg.setResult("公司地址格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getPosition()) || registrationForm.getPosition() == null) {
            msg.setResult("职位不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getPosition().matches(Constant.USER_POSITION_REGULAR_EXPRESSION))) {
            msg.setResult("职位格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if ("".equals(registrationForm.getEmail()) || registrationForm.getEmail() == null) {
            msg.setResult("邮箱不能为空");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else if (!(registrationForm.getEmail().matches(Constant.EMAIL_REGULAR_EXPRESSION))) {
            msg.setResult("邮箱格式出错");
            msg.setMessage(registrationForm);
            return GsonUtil.getErrorJson(msg);
        } else {
            conferenceDao.addForm(registrationForm);
            return GsonUtil.getSuccessJson("成功提交");
        }
    }

    /*
    查找展会和会议
     */
    public String findConference(HashMap<String, String> args) {
        int pageNum = CommonUtil.formatPageNum(args.get("pageNum"));
        int categoryId = CommonUtil.formateParmNum(args.get("categoryId"));
        int timeType = CommonUtil.formatPageNum(args.get("timeType"));
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("content", args.get("content"));
        dataMap.put("categoryId", categoryId);

        //根据权限查找
        int userRole = CommonUtil.formateParmNum(args.get("userRole"));
        int userId = CommonUtil.formateParmNum(args.get("userId"));
        if (userRole != User.ROLE_MANAGER && userRole != 0) {
            List<Integer> ids = conferenceDao.selectMemberConference(userId);
            dataMap.put("ids", ids);
        }
        List<Conference> conferences = null;
        switch (timeType) {
            case 1:
                PageHelper.startPage(pageNum, PAGE_LENGTH);
                conferences = conferenceDao.findConference(dataMap);
                break;
            case 2:
                PageHelper.startPage(pageNum, PAGE_LENGTH);
                conferences = conferenceDao.findConferenceHadNotHold(dataMap);
                break;
            case 3:
                PageHelper.startPage(pageNum, PAGE_LENGTH);
                conferences = conferenceDao.findConferenceHadHold(dataMap);
            default:
                break;
        }

        PageInfo<Conference> pageInfo = new PageInfo<>(conferences);
        for (Conference conference : conferences) {
            conference.setIntroduction(CommonUtil.getPreview(conference.getIntroduction()));
            conference.setPostDate(CommonUtil.formateDbTime(conference.getPostDate()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    public String getInfo(int id){
        Conference conference = conferenceDao.getInfo(id);
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Conference.class,"userId","conferenceType"),conference);
    }
}
