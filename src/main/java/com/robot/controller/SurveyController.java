package com.robot.controller;

import com.robot.annotation.PermissionsCheck;
import com.robot.entity.Answer;
import com.robot.entity.Question;
import com.robot.entity.Survey;
import com.robot.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author asce
 * @date 2018/11/15
 */
@RequestMapping(value = "/survey")
@Controller
public class SurveyController {
    @Autowired
    SurveyService surveyService;

    /**
     * 新增问卷
     * @param survey
     * @param session
     * @return
     */
    //@PermissionsCheck
    @RequestMapping(value = "/addSurvey", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addSurvey(Survey survey, HttpSession session){
        return surveyService.addSurvey(survey,session);
    }

    /**
     * 新增问题
     * @param question
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addQuestion(@RequestBody Question question){
        return surveyService.addQuestion(question);
    }

    /**
     * 回答问题
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addAnswer", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String addAnswer(@RequestBody Answer[] answers, HttpServletRequest request){
        return surveyService.addAnswer(answers, request);
    }
    /**
     * 获取问卷详情
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getSurveyInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getSurveyInfo(String id){
        return surveyService.getSurveyInfo(id);
    }
}
