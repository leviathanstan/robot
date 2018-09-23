package com.robot.entity;

/**
 * 机器人
 * @author asce
 * @date 2018/9/21
 */
public class Robot {

    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
