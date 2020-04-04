package com.robot.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * bidding
 * @author 
 */
public class Bidding implements Serializable {
    private Integer id;

    /**
     * 联系人
     */
    private String contactPeople;

    /**
     * 联系电话
     */
    private String contact;

    /**
     * 相关描述
     */
    private String description;

    /**
     * 附件地址
     */
    private String attachmentUrl;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 需求id
     */
    private Integer demandId;

    /**
     * 投标时间
     */
    private Date time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(String contactPeople) {
        this.contactPeople = contactPeople;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDemandId() {
        return demandId;
    }

    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}