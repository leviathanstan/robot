package com.robot.entity;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 职位
 * @author asce
 * @date 2018/11/20
 */
public class Position {
    private Integer id;
    private String positionName;
    private String companyName;
    private String companySize;
    private String companyNature;
    private String salary;
    private String degreeRequired;
    private String workAge;
    private String hiring;
    private String phone;
    private String jobDescription;
    private String companyIntroduction;
    private String createTime;
    private int viewCount;

    private ArrayList<Area> jobArea;
    private String areas;
    private String position;
    private String industry;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDegreeRequired() {
        return degreeRequired;
    }

    public void setDegreeRequired(String degreeRequired) {
        this.degreeRequired = degreeRequired;
    }

    public String getWorkAge() {
        return workAge;
    }

    public void setWorkAge(String workAge) {
        this.workAge = workAge;
    }

    public String getHiring() {
        return hiring;
    }

    public void setHiring(String hiring) {
        this.hiring = hiring;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyIntroduction() {
        return companyIntroduction;
    }

    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public ArrayList<Area> getJobArea() {
        return this.jobArea;
    }
    /**
     * 按照地区大小转换为一个字符串
     * @author asce
     * @date 2018/11/20
     * @param
     * @return
     */
    public void setJobArea(ArrayList<Area> jobArea) {
        jobArea.sort(Comparator.comparing(Area::getId));
        String str = "";
        for(Area area:jobArea){
            str += area.getName() + " ";
        }
        areas = str;
        this.jobArea = jobArea;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companySize='" + companySize + '\'' +
                ", companyNature='" + companyNature + '\'' +
                ", salary='" + salary + '\'' +
                ", degreeRequired='" + degreeRequired + '\'' +
                ", workAge='" + workAge + '\'' +
                ", hiring='" + hiring + '\'' +
                ", phone='" + phone + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", companyIntroduction='" + companyIntroduction + '\'' +
                ", createTime='" + createTime + '\'' +
                ", viewCount=" + viewCount +
                ", jobArea=" + jobArea +
                ", position='" + position + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }
}
