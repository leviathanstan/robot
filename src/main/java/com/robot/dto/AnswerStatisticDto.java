package com.robot.dto;

import com.robot.entity.Answer;

import java.util.ArrayList;

/**
 * 选项统计
 * @author asce
 * @date 2018/11/27
 */
public class AnswerStatisticDto {
    private ArrayList<ChoiceStatisticDto> choiceStatisticDtos;
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
}
