package com.robot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品
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
    public String load;
    public String axis;
    public LocalDate effectTime;
    public LocalDateTime lastUpdateTime;
    public Area area;
    public Industry industry;
    public Brand brand;
    public Parts parts;
    public List<Robot> robots;

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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }

    @Override
    public String toString() {
        return "ProductController{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", introduction='" + introduction + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", company=" + company +
                ", load='" + load + '\'' +
                ", axis='" + axis + '\'' +
                ", effectTime=" + effectTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", area=" + area +
                ", industry=" + industry +
                ", brand=" + brand +
                ", parts=" + parts +
                ", robots=" + robots +
                '}';
    }
}
