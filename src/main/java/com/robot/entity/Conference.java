package com.robot.entity;


/**
 * @author asce
 * @date 2018/11/11
 */
public class Conference {

    private Integer id;
    private Integer userId;
    private String coverImg;
    private String title;
    private String holdTime;
    private String address;
    private String host;
    private String introduction;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(String holdTime) {
        this.holdTime = holdTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", coverImg='" + coverImg + '\'' +
                ", title='" + title + '\'' +
                ", holdTime=" + holdTime +
                ", address='" + address + '\'' +
                ", host='" + host + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
