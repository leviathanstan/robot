package com.robot.controller;

import com.robot.annotation.PermissionsCheck;
import com.robot.entity.Product;
import com.robot.enums.PermissionsModel;
import com.robot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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

    @PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/deleteProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String deleteProduct(@RequestParam List<Integer> ids){
        return productService.deleteProduct(ids);
    }

    @PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/updateProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateProduct(Product product){
        return productService.updateProduct(product);
    }

    @PermissionsCheck
    @ResponseBody
    @RequestMapping(value = "/manager/addProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addProduct(Product product){
        return productService.addProduct(product);
    }

    /**
     * 查找产品
     * @author asce
     * @date 2018/9/22
     * @param args  搜索关键字
     * @param pageNum
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getProductList", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String getProduct(Map<String,String> args, String pageNum){
        return productService.getProductList(args,pageNum);
    }

    /**
     * @author asce
     * @date 2018/9/22
     * @param id    产品id
     * @return
     */
    @ResponseBody
    @RequestMapping(value= "/getProductInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getProduct(String id){
        return productService.getProductInfo(id);
    }

    /**
     * @author chen
     * @date 2019/1/13
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getHotProduct",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findHotProduct(){
        return productService.findHotProduct();
    }
}
