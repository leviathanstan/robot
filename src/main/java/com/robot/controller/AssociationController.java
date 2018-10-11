package com.robot.controller;

import com.robot.service.AssociationService;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ning
 * @date 2018/10/11
 */
@Controller
@RequestMapping("/association")
public class AssociationController {

    @Autowired
    private AssociationService associationService;


    /**
     * 获取协会新闻详细信息
     * @author hua
     * @date 2018/10/11
     * @param urlId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRobotNewsInf/{urlId}",method = RequestMethod.GET)
    public String getRobotNewsInf(String urlId){
        return associationService.getRobotNewsInf(urlId);
    }

    /**
     *获取协会新闻最新9条
     * @author hua
     * @date 2018/10/11
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRobotNewsTop",method = RequestMethod.GET)
    public String getRobotNewsTop(){
        return associationService.getRobotNewsTop();
    }
}
