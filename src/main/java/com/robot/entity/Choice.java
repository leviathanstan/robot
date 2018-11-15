package com.robot.entity;

/**
 * 选项
 * @author asce
 * @date 2018/11/14
 */
public class Choice {
    private Integer id;
    private Integer questionId;
    private Integer serialNumber;               //0代表题号，null代表无效数据
    private Integer defaultStatus;              //0代表不选中，1代表选中，null代表无效数据
    private String title;
    private Integer type;//选项、文字            //0代表选项，1代表文字，null代表无效数据

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

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", serialNumber=" + serialNumber +
                ", defaultStatus=" + defaultStatus +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
