package com.robot.entity;

/**
 * 行业
 * @author asce
 * @date 2018/9/21
 */
public class Industry {

    private Integer id;
    private String name;
    private Integer industryCount;

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

    public Integer getIndustryCount() {
        return industryCount;
    }

    public void setIndustryCount(Integer industryCount) {
        this.industryCount = industryCount;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", industryCount=" + industryCount +
                '}';
    }
}
