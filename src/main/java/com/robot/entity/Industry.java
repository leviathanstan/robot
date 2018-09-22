package com.robot.entity;

/**
 * 行业
 * @author asce
 * @date 2018/9/21
 */
public class Industry {

    public Integer id;
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustryName() {
        return name;
    }

    public void setIndustryName(String industryName) {
        this.name = industryName;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "id=" + id +
                ", industryName='" + name + '\'' +
                '}';
    }
}
