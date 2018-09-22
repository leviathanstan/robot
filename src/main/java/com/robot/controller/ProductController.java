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
    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public String getProduct(Product product,String pageNum){
        return productService.getProduct(product,pageNum);
    }


}
