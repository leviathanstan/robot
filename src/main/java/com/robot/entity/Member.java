package com.robot.entity;

import java.util.Date;

public class Member {

    public static final String[] ENTERPRISE_TYPE = {"企业经营", "个体经营"}; //企业类型
    public static final String[] MANAGEMENT_MODEL = {"制造商", "贸易商"}; //经营模式

    private Integer id;
    private Integer enterpriseId;
    private String memberRank; //会员等级
    private String memberName; //单位全称
    private String memberType; //单位类型
    private String contact; //联络人
    private String memberNumber; //会员编号
    private String memberIdentifier; //会员证号
    private String contactInfo; //联络人资料

    private String contactInfoUrl; //联络人资料hash

    private String associationApproval; //协会审批意见
    private String unitApproval; //入会单位意见

    private String enterpriseName; //企业名称
    private String enterpriseType; //企业类型
    private String enterpriseScale; //企业规模
    private String location;    //所在地
    private String registeredCapital; //注册资本
    private Date registeredDate; //注册年份
    private String authenticationData; //资料认证

    private String authenticationDataUrl; //资料认证hash

    private String managementModel; //经营模式
    private String managementScope; //经营范围
    private String mainCamp; //主营行业
    private String mainApplication; //擅长应用
    private String developing;  //发展历程
    private String cooperativePartner; //合作伙伴
    private String mainCustomer; //主要客户

    private String postalCode;   //邮政编码
    private String contactNumber; //联系电话
    private String fax; //传真
    private String email; //电子邮件
    private String contactAddress; //联系地址
    private String contacts; //联系人
    private String department; //所在部门
    private String post; //职务
    private String qq;
    private String wechat;

    public String getAuthenticationDataUrl() {
        return authenticationDataUrl;
    }

    public void setAuthenticationDataUrl(String authenticationDataUrl) {
        this.authenticationDataUrl = authenticationDataUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberRank() {
        return memberRank;
    }

    public void setMemberRank(String memberRank) {
        this.memberRank = memberRank;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getMemberIdentifier() {
        return memberIdentifier;
    }

    public void setMemberIdentifier(String memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAssociationApproval() {
        return associationApproval;
    }

    public void setAssociationApproval(String associationApproval) {
        this.associationApproval = associationApproval;
    }

    public String getUnitApproval() {
        return unitApproval;
    }

    public void setUnitApproval(String unitApproval) {
        this.unitApproval = unitApproval;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public String getEnterpriseScale() {
        return enterpriseScale;
    }

    public void setEnterpriseScale(String enterpriseScale) {
        this.enterpriseScale = enterpriseScale;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getAuthenticationData() {
        return authenticationData;
    }

    public void setAuthenticationData(String authenticationData) {
        this.authenticationData = authenticationData;
    }

    public String getManagementModel() {
        return managementModel;
    }

    public void setManagementModel(String managementModel) {
        this.managementModel = managementModel;
    }

    public String getManagementScope() {
        return managementScope;
    }

    public void setManagementScope(String managementScope) {
        this.managementScope = managementScope;
    }

    public String getMainCamp() {
        return mainCamp;
    }

    public void setMainCamp(String mainCamp) {
        this.mainCamp = mainCamp;
    }

    public String getMainApplication() {
        return mainApplication;
    }

    public void setMainApplication(String mainApplication) {
        this.mainApplication = mainApplication;
    }

    public String getDeveloping() {
        return developing;
    }

    public void setDeveloping(String developing) {
        this.developing = developing;
    }

    public String getCooperativePartner() {
        return cooperativePartner;
    }

    public void setCooperativePartner(String cooperativePartner) {
        this.cooperativePartner = cooperativePartner;
    }

    public String getMainCustomer() {
        return mainCustomer;
    }

    public void setMainCustomer(String mainCustomer) {
        this.mainCustomer = mainCustomer;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getContactInfoUrl() {
        return contactInfoUrl;
    }

    public void setContactInfoUrl(String contactInfoUrl) {
        this.contactInfoUrl = contactInfoUrl;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberRank='" + memberRank + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberType='" + memberType + '\'' +
                ", contact='" + contact + '\'' +
                ", memberNumber='" + memberNumber + '\'' +
                ", memberIdentifier='" + memberIdentifier + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", associationApproval='" + associationApproval + '\'' +
                ", unitApproval='" + unitApproval + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", enterpriseType='" + enterpriseType + '\'' +
                ", enterpriseScale='" + enterpriseScale + '\'' +
                ", location='" + location + '\'' +
                ", registeredCapital='" + registeredCapital + '\'' +
                ", registeredDate=" + registeredDate +
                ", authenticationData='" + authenticationData + '\'' +
                ", authenticationDataUrl='" + authenticationDataUrl + '\'' +
                ", managementModel='" + managementModel + '\'' +
                ", managementScope='" + managementScope + '\'' +
                ", mainCamp='" + mainCamp + '\'' +
                ", mainApplication='" + mainApplication + '\'' +
                ", developing='" + developing + '\'' +
                ", cooperativePartner='" + cooperativePartner + '\'' +
                ", mainCustomer='" + mainCustomer + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", contacts='" + contacts + '\'' +
                ", department='" + department + '\'' +
                ", post='" + post + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                '}';
    }
}
