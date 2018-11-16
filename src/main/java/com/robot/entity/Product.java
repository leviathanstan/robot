package com.robot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 产品
 * @author asce
 * @date 2018/9/21
 */
public class Product {

    private Integer id;
    private String name;
    private int price;
    private String brand;
    private String introduction;
    private String coverImg;
    private Company company;
    private String load;     //负载
    private String axis;     //轴
    private String imgs;     //多张图片通过‘;’分割
    private String effectTime;
    private String lastUpdateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", introduction='" + introduction + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", company=" + company +
                ", load='" + load + '\'' +
                ", axis='" + axis + '\'' +
                ", imgs='" + imgs + '\'' +
                ", effectTime=" + effectTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
