package com.robot.entity;

import java.util.ArrayList;

/**
 * 问卷
 * @author asce
 * @date 2018/11/14
 */
public class Survey {
    private Integer id;
    private String title;
    private Integer userId;
    private String remark;
    private Integer templateType;//是否模板
    private String createTime;
    private ArrayList<Question> questions;
    private ArrayList<Integer> categoryIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public ArrayList<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(ArrayList<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", remark='" + remark + '\'' +
                ", templateType=" + templateType +
                ", createTime='" + createTime + '\'' +
                ", questions=" + questions +
                '}';
    }
}
