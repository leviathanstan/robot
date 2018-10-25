package com.robot.controller;

import com.robot.service.CompanyService;
import com.robot.util.GsonUtil;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ning
 * @date 2018/9/22
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 品牌展厅
     * @author Ning
     * @date 2018/9/22
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getBrand", method = RequestMethod.GET)
    public String getCompanyBrand(){
        return companyService.getCompanyBrand();
    }

    /**
     * 获得地区公司数量
     * @author Ning
     * @data 2018/9/22
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getCompanyArea", method = RequestMethod.GET)
    public String getCompanyArea(){
        return companyService.getCompanyArea();
    }


    /**
     * 获得特定的品牌
     * @author Ning
     * @data 2018/9/22
     * @param specifiedId
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getSpecifiedBrand", method = RequestMethod.GET)
    public String getSpecifiedBrand(Integer specifiedId){
        return companyService.getSpecifiedBrand(specifiedId);
    }

    /**
     * 获得公司详细信息
     * @author Ning
     * @data 2018/9/22
     * @param companyId
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getCompanyInfo", method = RequestMethod.GET)
    public String getCompanyInfo(Integer companyId){
        return companyService.getCompanyInfo(companyId);
    }

    /**
     * 根据会员id获得首页的会员具体新闻
     * @author Ning
     * @data 2019/10/19
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getMemberNewsInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getMemberNewsInfo(@RequestParam Integer memberId){
        return companyService.getMemberNewsInfo(memberId);
    }

    /**
     * 获取全部会员动态
     * @author Ning
     * @data 2019/10/19
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getMemberNewsList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getMemberNewsList(@RequestParam Integer pageNum){
        return companyService.getMemberNewsList(pageNum);
    }


    /**
     * 得到具体的企业新闻内容
     * @author Ning
     * @data 2018/10/24
     * @param newsId
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getCompanyNewsInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getCompanyNewsInfo(@RequestParam Integer newsId){
        return companyService.getCompanyNewsInfo(newsId);
    }
}
