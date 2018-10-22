package com.robot.entity;

import java.time.LocalDateTime;

/**
 * 资讯
 * @author asce
 * @date 2018/9/21
 */
public class Information {

    private Integer id;
    private String title;
    private String content;
    private String summary;
    private String source;
    private String link;
    private String coverImg;
    private String postDate;
    private int viewCount;

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    private int type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", source='" + source + '\'' +
                ", link='" + link + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", postDate='" + postDate + '\'' +
                ", type=" + type +
                '}';
    }
}
