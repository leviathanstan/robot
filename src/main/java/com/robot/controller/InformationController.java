package com.robot.controller;

import com.robot.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hua
 * @date 2018/9/24
 */
@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    /**
     * 获取资讯文章具体内容
     * @author hua
     * @date 2018/9/24
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getInformationInf",method = RequestMethod.GET)
    public String getInformationInf(int id){
        return informationService.getInformationInfo(id);
    }
}
