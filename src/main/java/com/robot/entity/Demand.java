package com.robot.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * demand
 * @author 
 */
public class Demand implements Serializable {
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 公司名称
     */
    private String enterprise;

    /**
     * 内容
     */
    private String content;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 联系人
     */
    private String contactPeople;

    /**
     * 发布时间
     */
    private Date creatTime;

    /**
     * 截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    private Integer userId;

    /**
     * 0—供应，1—需求
     */
    private Integer type;

    private static final long serialVersionUID = 1L;

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

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(String contactPeople) {
        this.contactPeople = contactPeople;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}