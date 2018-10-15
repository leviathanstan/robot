package com.robot.controller;

import com.robot.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "/findExpertInf/{id}",method = RequestMethod.GET)
    public String findExpertInf(@PathVariable Integer id){
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
    @RequestMapping(value = "/findUniversityInf/{id}",method = RequestMethod.GET)
    public String findUniversityInf(@PathVariable Integer id){
        return expertService.findUniversityInf(id);
    }

    /**
     * 获取专家智点文章的前八条
     * @author hua
     * @date 2018/9/27
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findExpertArtTop")
    public String findExpertArtTop(){
        return expertService.findExpertArtTop();
    }

    /**
     * 获取所有专家
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findAllExpert",method = RequestMethod.GET)
    public String findAllExpert(){
        return expertService.findAllExpert();
    }

    /**
     * 获取所有高校
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findAllUniversity",method = RequestMethod.GET)
    public String findAllUniversity(){
        return expertService.findAllUniversity();
    }
}
