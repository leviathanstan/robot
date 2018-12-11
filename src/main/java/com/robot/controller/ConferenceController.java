package com.robot.controller;

import com.robot.annotation.PermissionsCheck;
import com.robot.entity.Conference;
import com.robot.entity.RegistrationForm;
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

    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/deleteConference", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String deleteConference(int id, HttpSession session){
        return conferenceService.deleteConference(id, session);
    }

    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/updateConference", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateConference(Conference conference,HttpSession session){
        return conferenceService.updateConference(conference,session);
    }

    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/addConference", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addConference(Conference conference,HttpSession session){
        return conferenceService.addConference(conference,session);
    }

    @ResponseBody
    @RequestMapping(value = "/getPassConference", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getPassConference(){
        return conferenceService.getPassConference();
    }

    @ResponseBody
    @RequestMapping(value = "/getHoldingConferences", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getHoldingConferences(){
        return conferenceService.getHoldingConferences();
    }

    @ResponseBody
    @RequestMapping(value = "/getConferenceList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getConferenceList(String pageNum){
        return conferenceService.getConferenceList(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/attend", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String writeForm(RegistrationForm registrationForm){
            return conferenceService.enroll(registrationForm);
    }

    @ResponseBody
    @RequestMapping(value = "/findConference",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findConference(@RequestParam HashMap args){
        return conferenceService.findConference(args);
    }
}
