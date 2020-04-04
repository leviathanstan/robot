package com.robot.dao;

import com.robot.entity.Demand;
import com.robot.entity.DemandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemandDao {
    long countByExample(DemandExample example);

    int deleteByExample(DemandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Demand record);

    int insertSelective(Demand record);

    List<Demand> selectByExample(DemandExample example);

    Demand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Demand record, @Param("example") DemandExample example);

    int updateByExample(@Param("record") Demand record, @Param("example") DemandExample example);

    int updateByPrimaryKeySelective(Demand record);

    int updateByPrimaryKey(Demand record);

    /**
     * 获取当前用户所有的需求id
     * @Author  xm
     * @Date 2020/4/2 17:38
     * @param userId	
     * @return java.util.List<java.lang.Integer>
     */
    List<Integer> selectUserDemand(int userId);
}