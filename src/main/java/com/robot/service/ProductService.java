package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.CategoryDao;
import com.robot.dao.ProductDao;
import com.robot.dto.CategoryDto;
import com.robot.entity.Product;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    @Autowired
    private CategoryDao categoryDao;

    /**
     * 筛选,查找产品
     * @author asce
     * @date 2018/9/22
     * @param product
     * @param pageNumStr
     * @return java.lang.String
     */
    public String getProductList(Product product,String pageNumStr){
        int pageNum = CommonUtil.formatPageNum(pageNumStr);
        PageHelper.startPage(pageNum,Constant.PRODUCT_PAGE_COUNT);
        List<Product> products = productDao.findProductIf(product);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        Map dataMap = new HashMap();
        dataMap.put("products",products);
        dataMap.put("pageInfo",pageInfo);
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     * 取得产品的所有可能分类
     * @author asce
     * @date 2018/9/22
     * @param
     * @return java.lang.String
     */
    public String getCategory(){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setAreas(categoryDao.getArea());
        categoryDto.setBrands(categoryDao.getBrand());
        categoryDto.setIndustries(categoryDao.getIndustry());
        categoryDto.setParts(categoryDao.getParts());
        categoryDto.setRobots(categoryDao.getRobot());
        Map dataMap = new HashMap();
        dataMap.put("category", categoryDto);
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     *
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
        Map dataMap = new HashMap();
        dataMap.put("product", product);
        return GsonUtil.getSuccessJson(dataMap);
    }
}
