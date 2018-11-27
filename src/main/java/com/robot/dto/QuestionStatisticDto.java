package com.robot.dto;

import com.robot.entity.Answer;
import com.robot.entity.Question;

import java.util.ArrayList;

/**
 * 选项统计
 * @author asce
 * @date 2018/11/27
 */
public class QuestionStatisticDto {
    private ArrayList<ChoiceStatisticDto> choiceStatisticDtos;
    private Question question;
    private int count;

    public ArrayList<ChoiceStatisticDto> getChoiceStatisticDtos() {
        return choiceStatisticDtos;
    }

    public void setChoiceStatisticDtos(ArrayList<ChoiceStatisticDto> choiceStatisticDtos) {
        this.choiceStatisticDtos = choiceStatisticDtos;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
