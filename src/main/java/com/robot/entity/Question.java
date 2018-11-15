package com.robot.entity;

import java.util.ArrayList;

/**
 * 问题
 * @author asce
 * @date 2018/11/14
 */
public class Question {
    private Integer id;
    private Integer serialNumber;//题号
    private String title;
    private Integer answerType;//单选、多选、文字、打分
    private Integer optionType;//可选、必选
    private Integer minNumber;//最少选项、字数
    private Integer maxNumber;//最多选项、字数
    private Integer precedentChoiceId;//先例选项
    private Integer page;//当前页数
    private ArrayList<Choice> choices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Integer answerType) {
        this.answerType = answerType;
    }

    public Integer getOptionType() {
        return optionType;
    }

    public void setOptionType(Integer optionType) {
        this.optionType = optionType;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getPrecedentChoiceId() {
        return precedentChoiceId;
    }

    public void setPrecedentChoiceId(Integer precedentChoiceId) {
        this.precedentChoiceId = precedentChoiceId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }
}
