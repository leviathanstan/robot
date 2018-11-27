package com.robot.dao;

import com.robot.entity.Answer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author asce
 * @date 2018/11/15
 */
public interface AnswerDao {
    int addTextAnswer(Answer answer);
    int addChoiceAnswer(Answer answer);
    int addRecord(HashMap<String,String> map);
    //ArrayList<String> getTextAnswerCount(int questionId);
    int getChoiceAnswerCount(int choiceId);
    int getAnswerCount(int questionId);

}
