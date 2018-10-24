package com.robot.entity;

/**
 * 技术
 * @author asce
 * @date 2018/10/23
 */
public class Technology {

    private int id;
    private String title;
    private String postDate;
    private String img;

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

    public void setPostDate(String post_date) {
        this.postDate = post_date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", post_date='" + postDate + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
