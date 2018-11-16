package com.robot.dao;

import com.robot.entity.Introduction;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author asce
 * @date 2018/11/2
 */
public interface IntroductionDao {

    ArrayList<Introduction> getIndexIntroduction(Map<String,Integer> map);
    ArrayList<Introduction> getIntroductionList(int categoryId);
    Introduction findIntroductionInfo(int id);
    int delete(int id);
    int add(Introduction introduction);
    int update(Introduction introduction);
    String findIntroductionById(int id);
}
