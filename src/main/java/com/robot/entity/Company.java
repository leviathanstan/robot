package com.robot.entity;

import java.util.List;

/**
 * 企业
 * @author asce
 * @date 2018/9/21
 */
public class Company {

    private Integer id;
    private String name;
    private String introduction;
    private String logo;
    private String website;
    private String telephone;
    private String address;
    private List<Robot> robots;
    private List<Area> areas;
    private List<Industry> industries;

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<Industry> getIndustries() {
        return industries;
    }

    public void setIndustries(List<Industry> industries) {
        this.industries = industries;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", logo='" + logo + '\'' +
                ", website='" + website + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", robots=" + robots +
                ", areas=" + areas +
                ", industries=" + industries +
                '}';
    }
}
