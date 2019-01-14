package com.robot.entity;

import java.util.ArrayList;

/**
 * 行业报告
 * @author chen
 * @date 2019/1/13
 */
public class Report {

    private Integer id;
    private String url;
    private String guide;//导读
    private String cover;
    private String title;
    private String industry;//所属行业
    private String production;//出品单位
    private String editor;//报告主编
    private String firstPostDate;//首次出版时间
    private String newPostDate;//最新修订时间
    private String delivery;//交付方式
    private String reportPage;//报告页码
    private String reportNum;//报告字数
    private String graphNum;//图表数量
    private String content;
    private ArrayList<String> keywords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getFirstPostDate() {
        return firstPostDate;
    }

    public void setFirstPostDate(String firstPostDate) {
        this.firstPostDate = firstPostDate;
    }

    public String getNewPostDate() {
        return newPostDate;
    }

    public void setNewPostDate(String newPostDate) {
        this.newPostDate = newPostDate;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getReportPage() {
        return reportPage;
    }

    public void setReportPage(String reportPage) {
        this.reportPage = reportPage;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public String getGraphNum() {
        return graphNum;
    }

    public void setGraphNum(String graphNum) {
        this.graphNum = graphNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", guide='" + guide + '\'' +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", industry='" + industry + '\'' +
                ", production='" + production + '\'' +
                ", editor='" + editor + '\'' +
                ", first_post_date='" + firstPostDate + '\'' +
                ", new_post_date='" + newPostDate + '\'' +
                ", delivery='" + delivery + '\'' +
                ", report_page='" + reportPage + '\'' +
                ", report_num='" + reportNum + '\'' +
                ", graph_num='" + graphNum + '\'' +
                ", content='" + content + '\'' +
                ", keywords=" + keywords +
                '}';
    }
}
