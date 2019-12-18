package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.entity.Conference;
import com.robot.entity.RegistrationForm;
import com.robot.entity.User;
import com.robot.enums.Role;
import com.robot.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


/**
 * @author Ning
 * @date 2018/9/27
 */
@Controller
@RequestMapping("/conference")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "/deleteConference", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String deleteConference(int id, HttpSession session){
        return conferenceService.deleteConference(id, session);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "/updateConference", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateConference(Conference conference,HttpSession session){
        return conferenceService.updateConference(conference,session);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "/addConference", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addConference(Conference conference,HttpSession session){
        return conferenceService.addConference(conference,session);
    }

    @ResponseBody
    @RequestMapping(value = "/getPassConference", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getPassConference(String pageNum){
        return conferenceService.getPassConference(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/getHoldingMeeting", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getHoldingMeeting(String pageNum){
        return conferenceService.getHoldingMeeting(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/getPassMeeting", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getPassMeeting(String pageNum){
        return conferenceService.getPassMeeting(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/getHoldingConferences", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getHoldingConferences(String pageNum){
        return conferenceService.getHoldingConferences(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/getConferenceList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getConferenceList(String pageNum){
        return conferenceService.getConferenceList(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/getMeetingList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getMeetingList(String pageNum){
        return conferenceService.getMeetingList(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/attend", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String writeForm(RegistrationForm registrationForm){
            return conferenceService.enroll(registrationForm);
    }

    @ResponseBody
    @RequestMapping(value = "/findConference",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findConference(@RequestParam HashMap<String,String> args,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user != null){
            args.put("userRole",user.getRole().toString());
            args.put("userId",user.getId().toString());
        }
        return conferenceService.findConference(args);
    }


    @ResponseBody
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getInfo(int id){
        return conferenceService.getInfo(id);
    }
}
