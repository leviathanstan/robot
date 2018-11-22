package com.robot.controller;

import com.robot.annotation.PermissionsCheck;
import com.robot.entity.Answer;
import com.robot.entity.Choice;
import com.robot.entity.Question;
import com.robot.entity.Survey;
import com.robot.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author asce
 * @date 2018/11/15
 */
@RequestMapping(value = "/survey")
@Controller
public class SurveyController {
    @Autowired
    SurveyService surveyService;

    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/search", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String search(@RequestParam Map<String,String> args,HttpSession session){
        return surveyService.search(args,session);
    }

    /**
     * 删除问卷
     * @param id
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/deleteSurvey", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String deleteSurvey(int id){
        return surveyService.deleteSurveyById(id);
    }

    /**
     * 删除问题
     * @param id
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/deleteQuestion", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String deleteQuestion(int id){
        return surveyService.deleteQuestionById(id);
    }

    /**
     * 删除选项
     * @param id
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/deleteChoice", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String deleteChoice(int id){
        return surveyService.deleteChoiceById(id);
    }

    /**
     * 更新选项
     * @param choice
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/updateChoice", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateChoice(@RequestBody Choice[] choice){
        return surveyService.updateChoice(choice);
    }

    /**
     * 更新问题
     * @param question
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/updateQuestion", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateQuestion(@RequestBody Question question){
        return surveyService.updateQuestion(question);
    }

    /**
     * 更新问卷
     * @param survey
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/updateSurvey", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateSurvey(@RequestBody Survey survey){
        return surveyService.updateSurvey(survey);
    }
    /**
     * 新增问卷
     * @param survey
     * @param session
     * @return
     */
    //@PermissionsCheck
    @RequestMapping(value = "/manager/addSurvey", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addSurvey(@RequestBody Survey survey, HttpSession session){
        return surveyService.addSurvey(survey, session);
    }

    /**
     * 新增问题
     * @param question
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/addQuestion", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
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
     * 添加选项
     * @author asce
     * @date 2018/11/18
     * @param
     * @return
     */
    //@PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/addChoice", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String addChoices(@RequestBody Choice[] choices){
        return surveyService.addChoice(choices);
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
