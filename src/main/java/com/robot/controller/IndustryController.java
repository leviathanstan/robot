package com.robot.controller;

import com.robot.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ning
 * @date 2018/9/22
 */
@Controller
@RequestMapping("/industry")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    /**
     * 获得行业数量
     * @author Ning
     * @data 2018/9/22
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getIndustryCount", method = RequestMethod.GET)
    public String getCompanyIndustry(){
        return industryService.getIndustryCount();
    }

}
