package com.robot.entity;


import java.time.LocalDateTime;

/**
 * 文章
 * @author asce
 * @date 2018/9/22
 */
public class Article {

    private Integer id;
    private String title;
    private LocalDateTime releaseTime;
    private String link;
    private String summary;
    private String content;
    private String source;
    private String type;

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

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseTime=" + releaseTime +
                ", link='" + link + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
