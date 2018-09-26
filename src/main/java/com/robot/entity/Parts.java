package com.robot.entity;

/**
 * 机器人配件
 * @author asce
 * @date 2018/9/21
 */
public class Parts {

    private Integer id;
    private String name;
    private int PartsCount;

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

    public int getPartsCount() {
        return PartsCount;
    }

    public void setPartsCount(int partsCount) {
        PartsCount = partsCount;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PartsCount=" + PartsCount +
                '}';
    }
}
