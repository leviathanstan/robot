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

//    /**
//     * 获得地区公司数量
//     * @author Ning
//     * @data 2018/9/22
//     * @return java.lang.String
//     */
//    @ResponseBody
//    @RequestMapping(value = "/getCompanyArea", method = RequestMethod.GET)
//    public String getCompanyArea(){
//        return companyService.getCompanyArea();
//    }
//
//
//    /**
//     * 获得特定的品牌
//     * @author Ning
//     * @data 2018/9/22
//     * @param specifiedId
//     * @return java.lang.String
//     */
//    @ResponseBody
//    @RequestMapping(value = "/getSpecifiedBrand", method = RequestMethod.GET)
//    public String getSpecifiedBrand(@RequestParam Integer specifiedId){
//        return companyService.getSpecifiedBrand(specifiedId);
//    }

}
