package com.robot.entity;

/**
 * 行业
 * @author asce
 * @date 2018/9/21
 */
public class Industry {

    public Integer id;
    public String industryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "id=" + id +
                ", industryName='" + industryName + '\'' +
                '}';
    }
}
