package com.robot.entity;


public class RobotNews {

    private String id;
    private String url;
    private String title;
    private int viewCount;
    private String content;
    private String postDate;
    private String source;
    private String img;

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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int amount) {
        this.viewCount = amount;
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

    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "RobotNews{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", amount=" + viewCount +
                ", content='" + content + '\'' +
                ", postDate='" + postDate + '\'' +
                ", source='" + source + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
