package com.robot.dao;

import com.robot.entity.Bidding;
import com.robot.entity.BiddingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BiddingDao {
    long countByExample(BiddingExample example);

    int deleteByExample(BiddingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bidding record);

    int insertSelective(Bidding record);

    List<Bidding> selectByExample(BiddingExample example);

    Bidding selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bidding record, @Param("example") BiddingExample example);

    int updateByExample(@Param("record") Bidding record, @Param("example") BiddingExample example);

    int updateByPrimaryKeySelective(Bidding record);

    int updateByPrimaryKey(Bidding record);
}