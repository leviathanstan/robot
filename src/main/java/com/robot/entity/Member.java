package com.robot.entity;

/**
 * 会员实体类
 * @author Ning
 * @date 2018/10/11
 */
public class Member {
    private Integer id;
    private String memberName;
    private String position;
    private Integer companyId;

    public Member() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", position='" + position + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
