package com.robot.entity;

/**
 * 评论
 */
public class Comment {
    private int id;
    private String comments;
    private String time;    //发布时间
    private int informationId;  //文章id
    private User user;      //发表者
    private int replyCount; //回复数
    private String file;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public int getInformationId() {
        return informationId;
    }

    public void setInformationId(int informationId) {
        this.informationId = informationId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", comments='" + comments + '\'' + ", time='" + time + '\'' + ", informationId=" + informationId + ", user=" + user + ", replyCount=" + replyCount + '}';
    }
}
