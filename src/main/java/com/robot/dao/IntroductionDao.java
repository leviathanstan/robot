package com.robot.dao;

import com.robot.entity.Introduction;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author asce
 * @date 2018/11/2
 */
public interface IntroductionDao {

    ArrayList<Introduction> getIndexIntroduction(Map<String,Integer> map);
    ArrayList<Introduction> getIndexMemberList(Map<String,Integer> map);
    ArrayList<Introduction> getIntroductionList(int categoryId);
    Introduction findIntroductionInfo(int id);
    int delete(List<Integer> ids);
    int add(Introduction introduction);
    int update(Introduction introduction);
    String findIntroductionById(int id);
    ArrayList<Introduction> find(Map<String,Object> args);
    List<Integer> selectMemberIntroduction(int userId);
    void deleteMemberIntroduction(List<Integer> ids);
    void insertMemberIntroduction(@Param("introductionId")int introductionId, @Param("userId")int userId);
    List<Integer> selectMemberIntroductionByUIds(List<Integer> userIds);
    List<Introduction> selectIndexMemberIntroduction(@Param("categoryId") int categoryId,@Param("list") List<Integer> informationIds,@Param("number") int number);
}
