package com.robot.bean;

import java.util.List;

public class SpiderStatus {
    private String node_name;
    private String status;
    private String jobid;
    private List<String> projects;
    private String message;

    public String stackTrace(){
        return "SpiderStatus{" +
                "node_name='" + node_name + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    @Override
    public String toString() {
        return "SpiderStatus{" +
                "node_name='" + node_name + '\'' +
                ", status='" + status + '\'' +
                ", jobid='" + jobid + '\'' +
                ", projects=" + projects +
                ", message='" + message + '\'' +
                '}';
    }
}
