package com.robot.controller;

import com.robot.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hua
 * @date 2018/9/25
 */
@Controller
@RequestMapping("/expert")
public class ExpertController {

    @Autowired
    private ExpertService expertService;

    /**
     * 获取专家具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findExpertInf",method = RequestMethod.GET)
    public String findExpertInf(Integer id){
        return expertService.findExpertInf(id);
    }

    /**
     * 获取高校具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findUniversityInf",method = RequestMethod.GET)
    public String findUniversityInf(Integer id){
        return expertService.findUniversityInf(id);
    }
}
