package com.robot.entity;

/**
 * 地区
 * @author asce
 * @date 2018/9/21
 */
public class Area {

    private Integer id;
    private String name;
    private Integer areaCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaCount() {
        return areaCount;
    }

    public void setAreaCount(Integer areaCount) {
        this.areaCount = areaCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", areaCount=" + areaCount +
                '}';
    }
}
