package com.robot.dto;

/**
 * @author asce
 * @date 2019/1/21
 */
public class InformationDto {

    private int id;
    private String title;
    private String postDate;
    private String img;
    private String content;
    private String link;
    private Integer viewCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "InformationDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postDate='" + postDate + '\'' +
                ", img='" + img + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
