package com.robot.dao;

import com.robot.entity.LoginTime;
import com.robot.entity.LoginTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginTimeDao {
    long countByExample(LoginTimeExample example);

    int deleteByExample(LoginTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoginTime record);

    int insertSelective(LoginTime record);

    List<LoginTime> selectByExample(LoginTimeExample example);

    LoginTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoginTime record, @Param("example") LoginTimeExample example);

    int updateByExample(@Param("record") LoginTime record, @Param("example") LoginTimeExample example);

    int updateByPrimaryKeySelective(LoginTime record);

    int updateByPrimaryKey(LoginTime record);
}