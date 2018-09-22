package com.robot.entity;

/**
 * 机器人
 * @author asce
 * @date 2018/9/21
 */
public class Robot {

    public Integer id;
    public String robotName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", robotName='" + robotName + '\'' +
                '}';
    }
}
