package com.robot.dao;

import com.robot.entity.Choice;
import com.robot.entity.Question;
import com.robot.entity.Survey;

/**
 * 问卷、问题、选项表
 * @author asce
 * @date 2018/11/15
 */
public interface SurveyDao {
    int addSurvey(Survey survey);
    int addQuestion(Question question);
    int addChoice(Choice choice);
    Survey getSurveyInfo(int id);
    int updateSurvey(Survey survey);
    int updateQuestion(Question question);
    int updateChoice(Choice choice);
}
