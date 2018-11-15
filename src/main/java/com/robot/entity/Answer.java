package com.robot.entity;

/**
 * 问卷答案
 * @author asce
 * @date 2018/11/14
 */
public class Answer {
    private Integer id;
    private String ip;
    private Integer questionId;     //文字题或打分题
    private Integer choiceId;       //选择题
    private String content;         //1、文字题 2、打分题(1分："1"，二分："2",.....) 3、选择题选项是文字题

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", questionId=" + questionId +
                ", choiceId=" + choiceId +
                ", content='" + content + '\'' +
                '}';
    }
}
