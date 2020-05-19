package com.robot.entity;

import java.io.Serializable;

/**
 * ad
 * @author 
 */
public class Ad implements Serializable {
    private Integer id;

    /**
     * 图片
     */
    private String image;

    /**
     * 点击图片跳转到的链接
     */
    private String url;

    /**
     * 广告位置，1表示上方大横条位置，0表示右下角正方形广告的位置
     */
    private Byte position;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte getPosition() {
        return position;
    }

    public void setPosition(Byte position) {
        this.position = position;
    }
}