package com.robot.entity;


public class Member {

    public static final String[] ENTERPRISE_TYPE = {"企业经营", "个体经营"}; //企业类型
    public static final String[] MANAGEMENT_MODEL = {"制造商", "贸易商"}; //经营模式
    public static final Integer MEMBER_MOLD_ENTERPRISE = 1;
    public static final Integer MEMBER_MOLD_FACULTY = 2;
    public static final Integer MEMBER_MOLD_GOVERNMENT = 3;

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


    private Integer memberMold;     //会员类型 1企业 2科研院所 3政府
    private Integer memberMoldId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
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

    public String getContactInfoUrl() {
        return contactInfoUrl;
    }

    public void setContactInfoUrl(String contactInfoUrl) {
        this.contactInfoUrl = contactInfoUrl;
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

    public Integer getMemberMold() {
        return memberMold;
    }

    public void setMemberMold(Integer memberMold) {
        this.memberMold = memberMold;
    }

    public Integer getMemberMoldId() {
        return memberMoldId;
    }

    public void setMemberMoldId(Integer memberMoldId) {
        this.memberMoldId = memberMoldId;
    }

    public Member() {
    }

    public Member(Integer id, Integer enterpriseId, String memberRank, String memberName, String memberType, String contact, String memberNumber, String memberIdentifier, String contactInfo, String contactInfoUrl, String associationApproval, String unitApproval, Integer memberMold, Integer memberMoldId) {
        this.id = id;
        this.enterpriseId = enterpriseId;
        this.memberRank = memberRank;
        this.memberName = memberName;
        this.memberType = memberType;
        this.contact = contact;
        this.memberNumber = memberNumber;
        this.memberIdentifier = memberIdentifier;
        this.contactInfo = contactInfo;
        this.contactInfoUrl = contactInfoUrl;
        this.associationApproval = associationApproval;
        this.unitApproval = unitApproval;
        this.memberMold = memberMold;
        this.memberMoldId = memberMoldId;
    }
}
