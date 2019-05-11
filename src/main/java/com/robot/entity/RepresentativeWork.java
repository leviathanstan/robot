package com.robot.entity;

public class RepresentativeWork {
    private Integer enterpriseId;
    private String brand; //品牌
    private String version; //版本
    private String applicationArea; //应用领域
    private String applicationIndustry; //应用行业
    private String applicationScenario; //应用场景

    public RepresentativeWork() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(String applicationArea) {
        this.applicationArea = applicationArea;
    }

    public String getApplicationIndustry() {
        return applicationIndustry;
    }

    public void setApplicationIndustry(String applicationIndustry) {
        this.applicationIndustry = applicationIndustry;
    }

    public String getApplicationScenario() {
        return applicationScenario;
    }

    public void setApplicationScenario(String applicationScenario) {
        this.applicationScenario = applicationScenario;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Override
    public String toString() {
        return "RepresentativeWork{" +
                "enterpriseId=" + enterpriseId +
                ", brand='" + brand + '\'' +
                ", version='" + version + '\'' +
                ", applicationArea='" + applicationArea + '\'' +
                ", applicationIndustry='" + applicationIndustry + '\'' +
                ", applicationScenario='" + applicationScenario + '\'' +
                '}';
    }
}
