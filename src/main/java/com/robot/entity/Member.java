package com.robot.entity;

/**
 * 会员实体类
 * @author Ning
 * @date 2018/10/11
 */
public class Member {
    private Integer id;
    private String memberName;
    private Integer positionId;
    private String joinTime;
    private String introduction;

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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", positionId=" + positionId +
                ", joinTime='" + joinTime + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
