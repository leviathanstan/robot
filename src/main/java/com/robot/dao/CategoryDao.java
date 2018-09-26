package com.robot.dao;

import com.robot.dto.CategoryDto;
import com.robot.entity.*;

import java.util.List;

/**
 * ares、brand、robot_category、industry、parts表合并为一个dao
 * @author asce
 * @date 2018/9/22
 */
public interface CategoryDao {

    List<Area> getArea();
    List<Brand> getProductBrand();
    List<Industry> getProductIndustry();
    List<Robot> getProductRobot();
    List<Parts> getProductParts();
}
