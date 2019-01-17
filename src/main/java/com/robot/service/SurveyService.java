package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.AnswerDao;
import com.robot.dao.SurveyDao;
import com.robot.dto.ChoiceStatisticDto;
import com.robot.dto.QuestionStatisticDto;
import com.robot.dto.SurveyStatisticDto;
import com.robot.entity.*;
import com.robot.util.AccessUtil;
import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

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
     * 某问卷数据统计
     * @author asce
     * @date 2018/11/27
     * @param
     * @return
     */
    public String getSurveyStatistic(int surveyId){
        SurveyStatisticDto surveyStatisticDto = new SurveyStatisticDto();
        surveyStatisticDto.setCount(answerDao.getAnswerCount(surveyId));
        Survey survey = surveyDao.getSurveyInfo(surveyId);
        ArrayList<QuestionStatisticDto> questionStatisticDtos = new ArrayList<>();
        for(Question question:survey.getQuestions()){
            QuestionStatisticDto questionStatisticDto = new QuestionStatisticDto();
            questionStatisticDto.setQuestion(question);
            ArrayList<ChoiceStatisticDto> choiceStatisticDtos = new ArrayList<>();
            for(Choice choice:question.getChoices()){
                ChoiceStatisticDto choiceStatisticDto = new ChoiceStatisticDto();
                choiceStatisticDto.setChoice(choice);
                if(choice.getType()==0) {
                    choiceStatisticDto.setCount(answerDao.getChoiceAnswerCount(choice.getId()));
                }else if(choice.getType()==1){
                    //choiceStatisticDto.setCount(answerDao.getTextAnswerCount(question.getId()));
                }
                choiceStatisticDtos.add(choiceStatisticDto);
            }
            questionStatisticDto.setChoiceStatisticDtos(choiceStatisticDtos);
            questionStatisticDtos.add(questionStatisticDto);
        }
        surveyStatisticDto.setQuestionStatisticDtos(questionStatisticDtos);
        return GsonUtil.getSuccessJson(surveyStatisticDto);
    }

    /**
     * 搜索问卷
     * @author asce
     * @date 2018/11/19
     * @param
     * @return
     */
    public String search(Map<String,String> args, HttpSession session){
        int pageNum = CommonUtil.formatPageNum(args.get("pageNum"));
        PageHelper.startPage(pageNum,LENGTH);
        if (args.get("userId")=="0"){
            args.put("userId",((User)session.getAttribute("user")).getId()+"");
        }
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
    public String deleteSurveyById(List<Integer> ids){
        for(int id:ids){
            Survey survey = surveyDao.getSurveyInfo(id);
            for(Question  question:survey.getQuestions()){
                for(Choice choice:question.getChoices()){
                    answerDao.deleteChoiceAnswer(choice.getId());
                }
                surveyDao.deleteChoiceByQuestion(question.getId());
                //for()
                answerDao.deleteTextAnswer(question.getId());
                surveyDao.deleteQuestionById(question.getId());
            }
            surveyDao.deleteSurveyCategory(id);
            answerDao.deleteAnswerRecord(id);
            surveyDao.deleteSurveyById(id);
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
    @Transactional
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
    @Transactional(propagation = Propagation.REQUIRED)
    public String updateQuestion(Question question){
        String result = validateQuestion(question);
        if (!result.equals("success")){
            return GsonUtil.getErrorJson(result);
        }
        if (question.getPrecedentChoiceId() != null){
            Choice choice = surveyDao.getChoice(question.getPrecedentChoiceId());
            if (choice != null){
                Question q = surveyDao.getQuestionInfo(choice.getQuestionId());
                //防止题目相互关联选项
                if (q.getPrecedentQuestionId() != null){
                    for(Choice c:question.getChoices()){
                        if (c.getId() == q.getPrecedentChoiceId()){
                            return GsonUtil.getErrorJson("不能相互关联");
                        }
                    }
                }
                if (q.getSurveyId() != question.getSurveyId()){
                    return GsonUtil.getErrorJson("关联问卷无效");
                }
            } else{
                return GsonUtil.getErrorJson("关联选项无效");
            }
        }
        if (question.getPrecedentQuestionId() != null){
            Question q = surveyDao.getQuestionInfo(question.getPrecedentQuestionId());
            if (q != null){
                //防止题目间相互关联
                if (q.getPrecedentQuestionId() == question.getId()){
                    return GsonUtil.getErrorJson("题目间不能相互关联");
                }
                if (q.getSurveyId() != question.getSurveyId()){
                    return GsonUtil.getErrorJson("关联问卷无效");
                }
            } else{
                return GsonUtil.getErrorJson("关联题目无效");
            }
        }
        int n1 = surveyDao.updateQuestion(question);
        if(question.getChoices()!=null){
            for(Choice choice:question.getChoices()){
                n1 += surveyDao.updateChoice(choice);
            }
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
    @Transactional(propagation = Propagation.REQUIRED)
    public String updateSurvey(Survey survey){
        String result = validateSurvey(survey);
        if (!result.equals("success")){
            return GsonUtil.getErrorJson(result);
        }
        Survey dbSurvey = surveyDao.getSurveyInfo(survey.getId());
        if (dbSurvey==null){
            return GsonUtil.getErrorJson("没有此问卷");
        }
        survey.setUpdateTime(LocalDateTime.now().toString());
        //更新问卷群体
        surveyDao.deleteSurveyCategory(survey.getId());
        Map<String,String> map = new HashMap<>();
        map.put("surveyId", survey.getId()+"");
        if(survey.getCategoryIds()!=null){
            for(Integer categoryId:survey.getCategoryIds()){
                map.put("categoryId",categoryId+"");
                surveyDao.addSurveyCategory(map);
            }
        }
        //更新问题
        Question question;
        Question dbQuestion = null;
        Choice dbChoice = null;
        ArrayList<Question> dbQuestions = dbSurvey.getQuestions();
        for(int i = 0;i < survey.getQuestions().size();i++){
            question = survey.getQuestions().get(i);
            question.setSurveyId(survey.getId());
            if(question.getId()!=null) {
                surveyDao.updateQuestion(question);
            }else{
                addQuestion(question);
                continue;   //增加题目，跳过后续判断
            }
            //获取数据库记录的对应问题,question不是final,无法使用lambda
            if(dbQuestions!=null){
                for(Question dbQ:dbQuestions){
                    if(dbQ.getId()==question.getId()){
                        dbQuestion = dbQ;
                        break;
                    }
                }
                //移除发送参数中没有的问题
                if(dbQuestion!=null){
                    dbQuestions.remove(dbQuestion);
                    dbQuestion = null;
                }
            }
            //更新选项
            for(int j = 0;j<question.getChoices().size();j++){
                if(question.getChoices().get(j).getId()!=null){
                    surveyDao.updateChoice(question.getChoices().get(j));
                }else{
                    question.getChoices().get(j).setQuestionId(question.getId());
                    surveyDao.addChoice(question.getChoices().get(j));
                }
                //移除发送参数中没有的选项
                if(dbQuestion!=null){
                    for(Choice c:dbQuestion.getChoices()){
                        if (c.getId()==question.getChoices().get(j).getId()){
                            dbChoice = c;
                        }
                    }
                }
                if(dbChoice!=null){
                    dbQuestion.getChoices().remove(dbChoice);
                    dbChoice = null;
                }
            }
            if(dbQuestion!=null){
                for(Choice c:dbQuestion.getChoices()){
                    surveyDao.deleteChoiceById(c.getId());
                }
            }
        }
        if(dbQuestions!=null){
            for(Question q:dbQuestions){
                deleteQuestionById(q.getId());
            }
        }
        surveyDao.updateSurvey(survey);
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
    @Transactional(propagation = Propagation.REQUIRED)
    public String addSurvey(Survey survey, HttpSession session){
        String result = validateSurvey(survey);
        if (!result.equals("success")){
            return GsonUtil.getErrorJson(result);
        }
        User user = (User) session.getAttribute("user");
        // TODO: 2018/11/27  
        survey.setUserId(1);//user.getId());
        survey.setCreateTime(LocalDateTime.now().toString());
        survey.setUpdateTime(LocalDateTime.now().toString());
        if(!addSurvey(survey)) {
            return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson(survey.getId());
    }
    /**
     * 新建问卷，更新问卷，添加问卷公用
     * @author asce
     * @date 2018/12/1
     * @param
     * @return
     */
    @Transactional
    public boolean addSurvey(Survey survey){
        int sum = 0;
        if (surveyDao.addSurvey(survey)!=1){
            return false;
        }
        Map<String,String> map = new HashMap<>();
        map.put("surveyId", survey.getId()+"");
        for(Integer categoryId:survey.getCategoryIds()){
            map.put("categoryId",categoryId+"");
            sum += surveyDao.addSurveyCategory(map);
        }
        if (sum!= survey.getCategoryIds().size()){
            throw new RuntimeException();
        }
        for(Question question:survey.getQuestions()){
            question.setSurveyId(survey.getId());
            addQuestion(question);
        }
        return true;
    }
    /**
     * 添加题目
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    @Transactional(rollbackForClassName="RuntimeException",propagation = Propagation.REQUIRED)
    public String addQuestion(Question question){
        //判断前置选项是否符合，数据库不做外键关联
        if (question.getPrecedentChoiceId() != null){
            Choice choice = surveyDao.getChoice(question.getPrecedentChoiceId());
            if (choice != null){
                Question q = surveyDao.getQuestionInfo(choice.getQuestionId());
                if (q.getSurveyId() != question.getSurveyId()){
                    return GsonUtil.getErrorJson("关联问卷无效");
                }
            } else{
                return GsonUtil.getErrorJson("关联选项无效");
            }
        }
        if (question.getPrecedentQuestionId() != null){
            Question q = surveyDao.getQuestionInfo(question.getPrecedentQuestionId());
            if (q != null){
                if (q.getSurveyId() != question.getSurveyId()){
                    return GsonUtil.getErrorJson("关联问卷无效");
                }
            } else{
                return GsonUtil.getErrorJson("关联题目无效");
            }
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
     * @param args
     * @param request
     * @return
     */
    @Transactional(rollbackForClassName="RuntimeException")
    public String addAnswer(Map<String,Object> args, HttpServletRequest request){
        ArrayList<Answer> answers = new ArrayList<>();
        ArrayList arrayList = (ArrayList)args.get("questions");
        int surveyId = ((Double) args.get("surveyId")).intValue();
        for(Object answer:arrayList){
            answers.add(GsonUtil.getObjectFromJson(answer.toString(),Answer.class));
        }
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
        HashMap<String,String> map = new HashMap<>();
        map.put("ip",ip);
        map.put("surveyId",surveyId+"");
        map.put("answerTime",LocalDateTime.now().toString());
        sum += answerDao.addRecord(map);
        if(sum!=answers.size()+1){
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
        if (survey==null){
            return "没有问卷";
        }
        if (survey.getTitle()==null){
            return "标题不能为空";
        }
        if(survey.getTemplateType()!=0&&survey.getTemplateType()!=1){
            return "问卷类型错误";
        }
        if(survey.getRemark()==null){
            return "备注不能为空";
        }
        if(survey.getStatus()!=0&&survey.getStatus()!=1){
            return "发布状态不和法";
        }
        if(survey.getQuestions()!=null){
            String result;
            for(Question question:survey.getQuestions()){
                result = validateQuestion(question);
                if(!result.equals("success")){
                    return result;
                }
            }
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
        if(question==null){
            return "没有问题";
        }
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
        if(question.getTitle()==null){
            return "标题不能为空";
        }
        if(question.getChoices()!=null){
            for(Choice choice:question.getChoices()){
                result = validateChoice(choice);
                if(!result.equals("success")){
                    return result;
                }
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
        if(choice==null){
            return "没有选项";
        }
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
