package com.robot.entity;

import java.util.ArrayList;

/**
 * 问题
 * @author asce
 * @date 2018/11/14
 */
public class Question {
    private Integer id;
    private Integer surveyId;
    private Integer serialNumber;//题号                             0代表题号，null代表无效数据
    private String title;
    private Integer answerType;//单选:0、多选:1、文字:2、打分:3       null代表无效数据
    private Integer optionType;//可选:0、必选:1                      null代表无效数据
    private Integer minNumber;//最少选项、字数                       0代表无限制，null代表无效数据
    private Integer maxNumber;//最多选项、字数                       0代表无限制，null代表无效数据
    private Integer precedentChoiceId;//先例选项                    null代表无关联
    private Integer precedentQuestionId;//先例问题                  null代表无关联
    private Integer page;//当前页数                                 0代表无分页，null代表无效数据
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

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Integer getPrecedentQuestionId() {
        return precedentQuestionId;
    }

    public void setPrecedentQuestionId(Integer precedentQuestionId) {
        this.precedentQuestionId = precedentQuestionId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", surveyId=" + surveyId +
                ", serialNumber=" + serialNumber +
                ", title='" + title + '\'' +
                ", answerType=" + answerType +
                ", optionType=" + optionType +
                ", minNumber=" + minNumber +
                ", maxNumber=" + maxNumber +
                ", precedentChoiceId=" + precedentChoiceId +
                ", page=" + page +
                ", choices=" + choices +
                '}';
    }
}
