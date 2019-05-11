package com.robot.entity;

import com.robot.enums.Permission;
import com.robot.enums.Role;

import java.util.List;

/**
 * 用户
 * @author asce
 * @date 2018/9/21
 */
public class User {
    public static final Integer STATUS_WAIT = 1;
    public static final Integer STATUS_ACCESS = 2;
    public static final Integer STATUS_FAIL = 3;

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer rank;
    private List<Permission> permissions;
    private Role role;
    private Integer memberId;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", rank=" + rank +
                ", permissions=" + permissions +
                ", role='" + role + '\'' +
                '}';
    }
}
