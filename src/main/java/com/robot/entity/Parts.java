package com.robot.entity;

/**
 * 机器人配件
 * @author asce
 * @date 2018/9/21
 */
public class Parts {

    public Integer id;
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartsName() {
        return name;
    }

    public void setPartsName(String partsName) {
        this.name = partsName;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", partsName='" + name + '\'' +
                '}';
    }
}
