package com.robot.entity;

/**
 * 地区
 * @author asce
 * @date 2018/9/21
 */
public class Area {

    public Integer id;
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return name;
    }

    public void setAreaName(String areaName) {
        this.name = areaName;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaName='" + name + '\'' +
                '}';
    }
}
