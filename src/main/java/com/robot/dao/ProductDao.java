package com.robot.dao;

import com.robot.entity.Product;
<<<<<<< HEAD

=======
import com.robot.entity.Robot;
import com.robot.entity.RobotNews;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
import java.util.List;
import java.util.Map;

/**
 * @author asce
 * @date 2018/9/22
 */
public interface ProductDao {

    List<Product> findProductIf(Map<String,String> args);
    Product getProductInfo(int id);
<<<<<<< HEAD
=======
    ArrayList<Product> getProductLibrary();

>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
}
