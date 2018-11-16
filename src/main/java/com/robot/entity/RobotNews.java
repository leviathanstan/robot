package com.robot.entity;


import java.util.ArrayList;

public class RobotNews {

    private int id;
    private String url;
    private String title;
    private int viewCount;
    private ArrayList<Detail> content;
    private String postDate;
    private String source;
    private String readGuide;
    private String img;
    private int categoryId;

    public void setId(int urlId) {
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


    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public int getId() {
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

    public String getReadGuide() {
        return readGuide;
    }

    public void setReadGuide(String readGuide) {
        this.readGuide = readGuide;
    }

    public ArrayList<Detail> getContent() {
        return content;
    }

    public void setContent(ArrayList<Detail> content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "RobotNews{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", viewCount=" + viewCount +
                ", content=" + content +
                ", postDate='" + postDate + '\'' +
                ", source='" + source + '\'' +
                ", readGuide='" + readGuide + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
