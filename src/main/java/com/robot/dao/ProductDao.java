package com.robot.dao;

import com.robot.entity.Product;
import com.robot.entity.Robot;
import com.robot.entity.RobotNews;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author asce
 * @date 2018/9/22
 */
public interface ProductDao {

    List<Product> findProductIf(Map<String,String> args);
    Product getProductInfo(int id);
    ArrayList<Product> getProductLibrary();

}
