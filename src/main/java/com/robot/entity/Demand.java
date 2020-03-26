package com.robot.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * create by 聪 on 2018/1/23
 */
public class Demand {

    private Integer dmdId;  //需求Id

    private String dmdTitle;  //需求标题

    private String dmdSummary;  //需求摘要

    private String dmdContent;  //需求内容

    private Area dmdArea;  //需求地区

    private int dmdType;  //需求类型

    private DmdCategory dmdCategoryId;  //需求分类

    private String dmdContact;  //联系方式

    private int dmdContactPublished;  //公布联系方式

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dmdTime;  //需求发布的时间

    private User user;  //用户


    public Integer getDmdId() {
        return dmdId;
    }

    public void setDmdId(Integer dmdId) {
        this.dmdId = dmdId;
    }

    public String getDmdTitle() {
        return dmdTitle;
    }

    public void setDmdTitle(String dmdTitle) {
        this.dmdTitle = dmdTitle;
    }

    public String getDmdSummary() {
        return dmdSummary;
    }

    public void setDmdSummary(String dmdSummary) {
        this.dmdSummary = dmdSummary;
    }

    public String getDmdContent() {
        return dmdContent;
    }

    public void setDmdContent(String dmdContent) {
        this.dmdContent = dmdContent;
    }

    public Area getDmdArea() {
        return dmdArea;
    }

    public void setDmdArea(Area dmdArea) {
        this.dmdArea = dmdArea;
    }

    public int getDmdType() {
        return dmdType;
    }

    public void setDmdType(int dmdType) {
        this.dmdType = dmdType;
    }

    public DmdCategory getDmdCategoryId() {
        return dmdCategoryId;
    }

    public void setDmdCategoryId(DmdCategory dmdCategoryId) {
        this.dmdCategoryId = dmdCategoryId;
    }

    public String getDmdContact() {
        return dmdContact;
    }

    public void setDmdContact(String dmdContact) {
        this.dmdContact = dmdContact;
    }

    public int getDmdContactPublished() {
        return dmdContactPublished;
    }

    public void setDmdContactPublished(int dmdContactPublished) {
        this.dmdContactPublished = dmdContactPublished;
    }

    public Date getDmdTime() {
        return dmdTime;
    }

    public void setDmdTime(Date dmdTime) {
        this.dmdTime = dmdTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Demand() {
    }

    @Override
    public String toString() {
        return "Demand{" +
                "dmdId=" + dmdId +
                ", dmdTitle='" + dmdTitle + '\'' +
                ", dmdSummary='" + dmdSummary + '\'' +
                ", dmdContent='" + dmdContent + '\'' +
                ", dmdArea=" + dmdArea +
                ", dmdType=" + dmdType +
                ", dmdCategoryId=" + dmdCategoryId +
                ", dmdContact='" + dmdContact + '\'' +
                ", dmdContactPublished=" + dmdContactPublished +
                ", dmdTime=" + dmdTime +
                ", accountId=" + user +
                '}';
    }
}
