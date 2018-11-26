package com.robot.dao;

import com.robot.entity.Choice;
import com.robot.entity.Question;
import com.robot.entity.Survey;

import java.util.ArrayList;
import java.util.Map;

/**
 * 问卷、问题、选项表
 * @author asce
 * @date 2018/11/15
 */
public interface SurveyDao {
    int addSurvey(Survey survey);
    int addSurveyCategory(Map<String,String> map);
    int addQuestion(Question question);
    int addChoice(Choice choice);
    Survey getSurveyInfo(int id);
    Question getQuestionInfo(int id);
    int updateSurvey(Survey survey);
    int updateQuestion(Question question);
    int updateChoice(Choice choice);
    int deleteSurveyById(int id);
    int deleteSurveyCategory(int surveyId);
    int deleteQuestionById(int id);
    int deleteChoiceById(int id);
    int deleteChoiceByQuestion(int id);
    ArrayList<Survey> search(Map<String,String> args);
}
