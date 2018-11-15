package com.robot.dao;

import com.robot.entity.Answer;

/**
 * @author asce
 * @date 2018/11/15
 */
public interface AnswerDao {
    int addTextAnswer(Answer answer);
    int addChoiceAnswer(Answer answer);
}
