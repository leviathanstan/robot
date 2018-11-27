package com.robot.dto;

import java.util.ArrayList;

/**
 * 问卷统计
 * @author asce
 * @date 2018/11/27
 */
public class SurveyStatisticDto {
    private ArrayList<QuestionStatisticDto> questionStatisticDtos;
    private int count;

    public ArrayList<QuestionStatisticDto> getQuestionStatisticDtos() {
        return questionStatisticDtos;
    }

    public void setQuestionStatisticDtos(ArrayList<QuestionStatisticDto> questionStatisticDtos) {
        this.questionStatisticDtos = questionStatisticDtos;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
