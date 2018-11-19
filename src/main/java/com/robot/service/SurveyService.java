package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.AnswerDao;
import com.robot.dao.SurveyDao;
import com.robot.entity.*;
import com.robot.util.AccessUtil;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.jgss.GSSUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    private final int LENGTH = 10;

    /**
     * 搜索问卷
     * @author asce
     * @date 2018/11/19
     * @param
     * @return
     */
    public String search(Map<String,String> args){
        int pageNum = CommonUtil.formatPageNum(args.get("pageNum"));
        PageHelper.startPage(pageNum,LENGTH);
        List<Survey> surveys = surveyDao.search(args);
        PageInfo<Survey> pageInfo = new PageInfo<>(surveys);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 删除问卷
     * @author asce
     * @date 2018/11/18
     * @param
     * @return
     */
    @Transactional
    public String deleteSurveyById(int id){
        int sum = 0, num = 0;
        Survey survey = surveyDao.getSurveyInfo(id);
        for(Question  question:survey.getQuestions()){
            num += question.getChoices().size() + 1;
            sum += surveyDao.deleteChoiceByQuestion(question.getId());
            sum += surveyDao.deleteQuestionById(question.getId());
        }
        sum += surveyDao.deleteSurveyById(id);
        if (sum != num + 1){
            throw new RuntimeException();
        }
        return GsonUtil.getSuccessJson();
    }
    /**
     * 删除单个问题
     * @author asce
     * @date 2018/11/18
     * @param
     * @return
     */
    @Transactional
    public String deleteQuestionById(int id){
        int sum = 0;
        Question question = surveyDao.getQuestionInfo(id);
        sum += surveyDao.deleteChoiceByQuestion(id);
        sum += surveyDao.deleteQuestionById(id);
        if (sum != question.getChoices().size()+1){
            throw new RuntimeException();
        }
        return GsonUtil.getSuccessJson();
    }
    /**
     * 删除单个选项
     * @author asce
     * @date 2018/11/18
     * @param
     * @return
     */
    public String deleteChoiceById(int id){
        if (surveyDao.deleteChoiceById(id)!=1){
            return GsonUtil.getErrorJson("删除失败");
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 更新选项
     * @author asce
     * @date 2018/11/18
     * @param
     * @return
     */
    public String updateChoice(Choice[] choices){
        int sum = 0;
        for(Choice choice:choices){
            String result = validateChoice(choice);
            if (!result.equals("success")){
                return GsonUtil.getErrorJson(result);
            }
        }
        for(Choice choice:choices){
            sum += surveyDao.updateChoice(choice);
        }
        if(sum!=choices.length){
            throw new RuntimeException();
        }
        return GsonUtil.getSuccessJson();
    }
    /**
     * 更新问题
     * @author asce
     * @date 2018/11/18
     * @param
     * @return
     */
    @Transactional
    public String updateQuestion(Question question){
        String result = validateQuestion(question);
        if (!result.equals("success")){
            return GsonUtil.getErrorJson(result);
        }
        int n1 = surveyDao.updateQuestion(question);
        for(Choice choice:question.getChoices()){
            n1 += surveyDao.updateChoice(choice);
        }
        if(n1!=(question.getChoices().size()+1)){
            throw new RuntimeException();
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 更新问卷
     * @author asce
     * @date 2018/11/18
     * @param
     * @return
     */
    public String updateSurvey(Survey survey){
        String result = validateSurvey(survey);
        if (!result.equals("success")){
            return GsonUtil.getErrorJson(result);
        }
        if(surveyDao.updateSurvey(survey)!=1){
            return GsonUtil.getErrorJson("修改失败");
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 添加选项
     * @author asce
     * @date 2018/11/18
     * @param
     * @return
     */
    @Transactional
    public String addChoice(Choice[] choices){
        int sum = 0;
        for(Choice choice:choices){
            String result = validateChoice(choice);
            if (!result.equals("success")){
                return GsonUtil.getErrorJson(result);
            }
        }
        for(Choice choice:choices){
            sum += surveyDao.addChoice(choice);
        }
        if(sum!=choices.length){
            throw new RuntimeException();
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 新建问卷
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    public String addSurvey(Survey survey, HttpSession session){
        String result = validateSurvey(survey);
        if (!result.equals("success")){
            return GsonUtil.getErrorJson(result);
        }
        User user = (User) session.getAttribute("user");
        survey.setUserId(1);//user.getId());
        survey.setCreateTime(LocalDateTime.now().toString());
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
        String result = validateQuestion(question);
        if (!result.equals("success")){
            return GsonUtil.getErrorJson(result);
        }
        int n1 = surveyDao.addQuestion(question);
        for(Choice choice:question.getChoices()){
            choice.setQuestionId(question.getId());
            n1 += surveyDao.addChoice(choice);
        }
        if(n1 != (question.getChoices().size()+1)){
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
     * 验证问卷
     * @author asce
     * @date 2018/11/16
     * @param
     * @return
     */
    private String validateSurvey(Survey survey){
        if (survey.getTitle()==null){
            return "标题不能为空";
        }
        if(survey.getTemplateType()!=0||survey.getTemplateType()!=1){
            return "问卷类型错误";
        }
        if(survey.getRemark()==null){
            return "备注不能为空";
        }
        return "success";
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
        if (question.getSerialNumber()==null){
            return "序号不能为空";
        }
        if(question.getAnswerType()==null||(question.getAnswerType()!=0&&question.getAnswerType()!=1&&question.getAnswerType()!=2&&question.getAnswerType()!=3)){
            return "问题类型错误";
        }
        if(question.getMaxNumber()==null){
            return "最大限制不能为空";
        }
        if(question.getMinNumber()==null){
            return "最小限制不能为空";
        }
        if(question.getOptionType()==null||(question.getOptionType()!=0&&question.getOptionType()!=1)){
            return "选项类型错误";
        }
        if(question.getPage()==null){
            return "页数不能为空";
        }
        if(question.getSurveyId()==null){
            return "没有关联问卷";
        }
        if(question.getTitle()==null){
            return "标题不能为空";
        }
        for(Choice choice:question.getChoices()){
            result = validateChoice(choice);
            if(!result.equals("success")){
                return result;
            }
        }
        return "success";
    }
    /**
     * 验证选项格式
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    private String validateChoice(Choice choice){
        if(choice.getSerialNumber()==null){
            return "序号不能为空";
        }
        if (choice.getDefaultStatus()==null||(choice.getDefaultStatus()!=0&&choice.getDefaultStatus()!=1)){
            return "默认状态错误";
        }
        if(choice.getType()==null||(choice.getType()!=0&&choice.getType()!=1)){
            return "选项类型不能为空";
        }
        if(choice.getTitle()==null){
            return "标题不能为空";
        }
        return "success";
    }
}
