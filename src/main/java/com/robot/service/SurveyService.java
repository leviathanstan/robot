package com.robot.service;

import com.robot.dao.AnswerDao;
import com.robot.dao.SurveyDao;
import com.robot.entity.*;
import com.robot.util.AccessUtil;
import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author asce
 * @date 2018/11/15
 */
@Service
public class SurveyService {

    @Autowired
    SurveyDao surveyDao;
    @Autowired
    AnswerDao answerDao;

    /**
     * 新建问卷
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    public String addSurvey(Survey survey, HttpSession session){
        User user = (User) session.getAttribute("user");
        survey.setUserId(1);//user.getId());
        if (surveyDao.addSurvey(survey)!=1){
            return GsonUtil.getErrorJson("创建失败");
        }
        return GsonUtil.getSuccessJson();
    }
    /**
     * 添加题目
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    @Transactional(rollbackForClassName="RuntimeException")
    public String addQuestion(Question question){
        int n1 = surveyDao.addQuestion(question);
        int n2 = 0;
        for(Choice choice:question.getChoices()){
            n2 += surveyDao.addChoice(choice);
        }
        if((n1+n2)!=(question.getChoices().size()+1)){
            throw new RuntimeException();
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 回答问题
     * @param answers
     * @param request
     * @return
     */
    @Transactional(rollbackForClassName="RuntimeException")
    public String addAnswer(Answer[] answers, HttpServletRequest request){
        String ip = AccessUtil.getIpAddress(request);
        int sum = 0;
        for(Answer answer:answers){
            answer.setIp(ip);
            if(answer.getChoiceId()!=null){
                sum += answerDao.addChoiceAnswer(answer);
            }else if (answer.getQuestionId()!=null&&answer.getContent()!=null){
                sum += answerDao.addTextAnswer(answer);
            }
        }
        if(sum!=answers.length){
            throw new RuntimeException();
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 获取问卷详情
     * @param surveyId
     * @return
     */
    public String getSurveyInfo(String surveyId){
        int id = CommonUtil.formateParmNum(surveyId);
        Survey survey = surveyDao.getSurveyInfo(id);
        if (survey==null){
            return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson(survey);
    }

    /**
     * 验证问题格式
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    private String validateQuestion(Question question){
        String result;

        for(Choice choice:question.getChoices()){
            result = validateChoice(choice);
            if(!result.equals("success")){
                return result;
            }
        }
        return "";
    }
    /**
     * 验证选项格式
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    private String validateChoice(Choice choice){

        return "";
    }
}
