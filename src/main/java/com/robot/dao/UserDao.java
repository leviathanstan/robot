package com.robot.dao;

import com.robot.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    /**
     * 查询用户名是否已存在
     */
    User checkUsername(User user);

    /**
     * 查询邮箱是否已存在
     */
    User checkEmail(User user);

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
     * 查找邮箱
     * @param email
     * @return
     */
    String findEmail(String email);

    /**
     * 修改密码
     * @param password
     * @param email
     * @return
     */
    int resetPassword(@Param("password") String password, @Param("email") String email);


}
