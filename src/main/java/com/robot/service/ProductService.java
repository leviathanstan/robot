package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.robot.dao.ProductDao;
import com.robot.entity.Product;
import com.robot.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asce
 * @date 2018/9/22
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public String getProduct(Product product,String pageNumStr){
        int pageNum = CommonUtil.formatPageNum(pageNumStr);
        //PageHelper.st
        return null;
    }
}
