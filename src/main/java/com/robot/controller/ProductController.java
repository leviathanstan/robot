package com.robot.controller;

import com.robot.entity.Product;
import com.robot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author asce
 * @date 2018/9/22
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查找产品
     * @author asce
     * @date 2018/9/22
     * @param product
     * @param pageNum
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getProductList", method = RequestMethod.POST)
    public String getProduct(Product product,String pageNum){
        return productService.getProductList(product,pageNum);
    }

    /**
     *  获取产品所有分类
     * @author asce
     * @date 2018/9/22
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value= "/getCategory", method = RequestMethod.GET)
    public String getCategory(){
        return productService.getCategory();
    }

    /**
     *  获取产品详细信息
     * @author asce
     * @date 2018/9/22
     * @param id    产品id
     * @return
     */
    @ResponseBody
    @RequestMapping(value= "/getProductInfo", method = RequestMethod.GET)
    public String getProduct(String id){
        return productService.getProductInfo(id);
    }
}
