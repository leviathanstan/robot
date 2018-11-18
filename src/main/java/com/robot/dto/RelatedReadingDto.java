package com.robot.dto;

import com.robot.entity.RobotNews;

import java.util.List;

/**
 * 相关阅读
 * @author asce
 * @date 2018/11/18
 */
public class RelatedReadingDto {
    private List<String> keywords;
    private List<RobotNews> information;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<RobotNews> getInformation() {
        return information;
    }

    public void setInformation(List<RobotNews> information) {
        this.information = information;
    }
}
