package com.robot.entity;

/**
 * 机器人
 * @author asce
 * @date 2018/9/21
 */
public class Robot {

    private Integer id;
    private String name;
    private int robotCount;

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

    public int getRobotCount() {
        return robotCount;
    }

    public void setRobotCount(int robotCount) {
        this.robotCount = robotCount;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", robotCount=" + robotCount +
                '}';
    }
}
