package com.robot.dao;

import com.robot.entity.Information;

import java.util.ArrayList;

/**
 * @author hua
 * @date 2018/9/24
 */
public interface InformationDao {

    Information findInformationInfo(int id);
    ArrayList<Information> findInformationTop(Integer id);
    ArrayList<Information> findInformationByPage(Integer categoryId);
}
