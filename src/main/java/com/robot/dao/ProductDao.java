package com.robot.dao;

import com.robot.entity.Product;
import org.apache.ibatis.annotations.Param;

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
    int getSearchCount(String content);
    int addProduct(Product product);
    int deleteProduct(List<Integer> id);
    int updateProduct(Product product);
    ArrayList<Product> findHotProduct();
    int addProCount(int id);
    ArrayList<Product> selectProductByIds(List<Integer> ids);
    int insertMemberProduct(@Param("productId")int productId,@Param("userId")int userId);
    List<Integer> selectMemberProduct(int userId);
    void deleteMemberProduct(List<Integer> ids);
}
