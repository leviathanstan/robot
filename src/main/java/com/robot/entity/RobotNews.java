package com.robot.entity;


public class RobotNews {

    private String id;
    private String url;
    private String title;
    private int amount;
    private String content;
    private String postDate;

    public String getUrlId() {
        return id;
    }

    public void setId(String urlId) {
        this.id = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "RobotNews{" +
                "urlId='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
