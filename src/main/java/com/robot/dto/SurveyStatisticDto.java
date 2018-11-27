package com.robot.dto;

import java.util.ArrayList;

/**
 * 问卷统计
 * @author asce
 * @date 2018/11/27
 */
public class SurveyStatisticDto {
    private ArrayList<AnswerStatisticDto> answerStatisticDtos;
    private int count;

    public ArrayList<AnswerStatisticDto> getAnswerStatisticDtos() {
        return answerStatisticDtos;
    }

    public void setAnswerStatisticDtos(ArrayList<AnswerStatisticDto> answerStatisticDtos) {
        this.answerStatisticDtos = answerStatisticDtos;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
