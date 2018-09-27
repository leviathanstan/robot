package com.robot.entity;

/**
 * 报名表
 * @author asce
 * @date 2018/9/21
 */
public class RegistrationForm {

    private Integer conferenceId;
    private String name;
    private String gender;
    private String phone;
    private String weChat;
    private String email;
    private String companyName;
    private String position;
    private String companyAddress;
    private String status;

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "conferenceId=" + conferenceId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", weChat='" + weChat + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
