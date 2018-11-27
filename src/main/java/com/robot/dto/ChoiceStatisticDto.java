package com.robot.dto;

import com.robot.entity.Choice;

/**
 * 选项统计
 * @author asce
 * @date 2018/11/27
 */
public class ChoiceStatisticDto {

    private Choice choice;
    private int count;

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
