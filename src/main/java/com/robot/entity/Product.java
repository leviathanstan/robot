package com.robot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 产品
 * @author asce
 * @date 2018/9/21
 */
public class Product {

    public Integer id;
    public String name;
    public int price;
    public String introduction;
    public String coverImg;
    public Company company;
    public String load;     //负载
    public String axis;     //轴
    public String imgs;     //多张图片通过‘;’分割
    public LocalDate effectTime;
    public LocalDateTime lastUpdateTime;
    //用作查询时作pojo使用，无关多对多的关系
    public Industry industry;
    public Brand brand;
    public Parts parts;
    public Robot robot;

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

    public LocalDate getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(LocalDate effectTime) {
        this.effectTime = effectTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", introduction='" + introduction + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", company=" + company +
                ", load='" + load + '\'' +
                ", axis='" + axis + '\'' +
                ", imgs='" + imgs + '\'' +
                ", effectTime=" + effectTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", industry=" + industry +
                ", brand=" + brand +
                ", parts=" + parts +
                ", robot=" + robot +
                '}';
    }
}
