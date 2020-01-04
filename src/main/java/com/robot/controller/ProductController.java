package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.entity.Product;
import com.robot.entity.User;
import com.robot.enums.Role;
import com.robot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Authority(role = Role.MEMBER_NORMAL)
    @ResponseBody
    @RequestMapping(value = "/manager/deleteProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String deleteProduct(@RequestParam List<Integer> ids){
        return productService.deleteProduct(ids);
    }

    @Authority(role = Role.MEMBER_NORMAL)
    @ResponseBody
    @RequestMapping(value = "/manager/updateProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateProduct(Product product){
        return productService.updateProduct(product);
    }

    @Authority(role = Role.MEMBER_NORMAL)
    @ResponseBody
    @RequestMapping(value = "/manager/addProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addProduct(@SessionAttribute("user") User user, Product product){
        return productService.addProduct(product,user);
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
     * 获取热门产品
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
