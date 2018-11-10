package com.robot.controller;

import com.robot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
     * @param args  搜索关键字
     * @param pageNum
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getProductList", method = RequestMethod.POST)
    public String getProduct(Map<String,String> args, String pageNum){
        return productService.getProductList(args,pageNum);
    }

    /**
<<<<<<< HEAD
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
=======
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
     *  获取产品详细信息
     * @author asce
     * @date 2018/9/22
     * @param id    产品id
     * @return
     */
    @ResponseBody
<<<<<<< HEAD
    @RequestMapping(value= "/getProductInfo/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable String id){
        return productService.getProductInfo(id);
    }
=======
    @RequestMapping(value= "/getProductInfo", method = RequestMethod.GET)
    public String getProduct(String id){
        return productService.getProductInfo(id);
    }

>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
}
