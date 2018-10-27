package com.robot.dto;

import com.robot.entity.*;

import java.util.List;

/**
 * 产品类别dto
 * @author asce
 * @date 2018/9/22
 */
public class CategoryDto {

    public List<Brand> brands;
    public List<Robot> robots;
    public List<Industry> industries;
    public List<Area> areas;
    public List<Parts> parts;

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }

    public List<Industry> getIndustries() {
        return industries;
    }

    public void setIndustries(List<Industry> industries) {
        this.industries = industries;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "brands=" + brands +
                ", robots=" + robots +
                ", industries=" + industries +
                ", areas=" + areas +
                ", parts=" + parts +
                '}';
    }
}
