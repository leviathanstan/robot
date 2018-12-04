package com.robot.dao;

import com.robot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ArrayReferenceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface UserDao {

    int register(User user);
    User login(User user);
    int resetPassword(@Param("password") String password, @Param("email") String email);
    ArrayList<User> find(User user);
    int addSubscribe(Map<String,Integer> map);
    int deleteSubscribe(Map<String,Integer> map);
    Integer selectSubscribeInfo(Map<String,Integer> map);
    ArrayList<Integer> getUserSubscribe(int userId);
    ArrayList<Map> getUserSubscribeInfo(int userId);
    ArrayList<Map> getAllSubscribe();
}
