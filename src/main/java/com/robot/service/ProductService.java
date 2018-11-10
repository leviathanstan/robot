package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
<<<<<<< HEAD
import com.robot.dao.CategoryDao;
import com.robot.dao.ProductDao;
import com.robot.dto.CategoryDto;
=======
import com.robot.dao.ProductDao;
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
import com.robot.entity.Product;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
import java.util.List;
import java.util.Map;

/**
 * @author asce
 * @date 2018/9/22
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;
<<<<<<< HEAD
    @Autowired
    private CategoryDao categoryDao;

=======
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
    /**
     * 筛选,查找产品
     * @author asce
     * @date 2018/9/22
     * @param args
     * @param pageNumStr
     * @return java.lang.String
     */
    public String getProductList(Map<String,String> args,String pageNumStr){
        int pageNum = CommonUtil.formatPageNum(pageNumStr);
        PageHelper.startPage(pageNum,Constant.PRODUCT_PAGE_COUNT);
        List<Product> products = productDao.findProductIf(args);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Product.class,"company","load","axis","imgs","effectTime","lastUpdateTime"),pageInfo);
    }

    /**
<<<<<<< HEAD
     * 取得产品的所有可能分类
     * @author asce
     * @date 2018/9/22
     * @param
     * @return java.lang.String
     */
    public String getCategory(){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setAreas(categoryDao.getArea());
        categoryDto.setBrands(categoryDao.getProductBrand());
        categoryDto.setIndustries(categoryDao.getProductIndustry());
        categoryDto.setParts(categoryDao.getProductParts());
        categoryDto.setRobots(categoryDao.getProductRobot());
        return GsonUtil.getSuccessJson(categoryDto);
    }

    /**
     *
=======
     * 产品具体信息
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
     * @author asce
     * @date 2018/9/22
     * @param idStr     产品id
     * @return
     */
    public String getProductInfo(String idStr){
        if (!CommonUtil.simpleMatch(Constant.RULE_NUMBER,idStr))
            return GsonUtil.getErrorJson();
        int id = Integer.parseInt(idStr);
        Product product = productDao.getProductInfo(id);
        return GsonUtil.getSuccessJson(product);
    }
<<<<<<< HEAD
=======


    /**
     * 首页产品库
     * @author Ning
     * @data 2018/10/24
     * @return java.lang.String
     */
    public ArrayList<Product> getProductLibrary() {
        return productDao.getProductLibrary();
    }


>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
}
