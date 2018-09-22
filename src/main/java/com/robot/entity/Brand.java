package com.robot.entity;

/**
 * 品牌
 * @author asce
 * @date 2018/9/21
 */
public class Brand {

    public Integer id;
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return name;
    }

    public void setBrandName(String brandName) {
        this.name = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + name + '\'' +
                '}';
    }
}
