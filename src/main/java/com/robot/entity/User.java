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

    public static final Integer ROLE_SUPER = 1;      //超级管理员 1
    public static final Integer ROLE_MANAGER = 2;   //管理员 2
    public static final Integer ROLE_ORGANIZER = 3;  //主办方 3
    public static final Integer ROLE_ASSOCIATION = 4;   //协会 4
    public static final Integer ROLE_MEMBER = 5;    //会员 5
    public static final Integer ROLE_MEMBER_NORMAL = 6; //会员普通成员 6
    public static final Integer ROLE_NORMAL = 7;    //普通人 7

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private List<Permission> permissions;
    private Integer role;
    private Integer enterpriseId;
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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
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
                ", permissions=" + permissions +
                ", role=" + role +
                ", enterpriseId=" + enterpriseId +
                ", status=" + status +
                '}';
    }
}
