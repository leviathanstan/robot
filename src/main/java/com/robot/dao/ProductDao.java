package com.robot.dao;

import com.robot.entity.Product;

import java.util.List;

/**
 * @author asce
 * @date 2018/9/22
 */
public interface ProductDao {

    List<Product> findProductIf(Product product);
}
