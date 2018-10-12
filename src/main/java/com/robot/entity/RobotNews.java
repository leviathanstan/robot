package com.robot.entity;

import java.time.LocalDateTime;

public class RobotNews {

    private String urlId;
    private String url;
    private String title;
    private int amount;
    private String content;
    private LocalDateTime postDate;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
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

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "RobotNews{" +
                "urlId='" + urlId + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
