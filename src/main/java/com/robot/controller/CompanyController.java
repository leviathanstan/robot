package com.robot.controller;

import com.robot.service.CompanyService;
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
    @RequestMapping(value = "/getSpecifiedBrand/{specifiedId}", method = RequestMethod.GET)
    public String getSpecifiedBrand(@PathVariable Integer specifiedId){
        return companyService.getSpecifiedBrand(specifiedId);
    }

    @ResponseBody
    @RequestMapping(value = "/getCompanyInfo", method = RequestMethod.GET)
    public String getCompanyInfo(@PathVariable Integer companyId){
        return companyService.getCompanyInfo(companyId);
    }
}
