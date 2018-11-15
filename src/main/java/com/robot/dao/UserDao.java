package com.robot.dao;

import com.robot.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserDao {

    /**
     * 注册
     * @param user
     */
    int register(User user);

    /**
     * 登陆
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 修改密码
     * @param password
     * @param email
     * @return
     */
    int resetPassword(@Param("password") String password, @Param("email") String email);

    ArrayList<User> find(User user);

}
