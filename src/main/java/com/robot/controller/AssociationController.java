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
     * 获得协会会员
     * @author Ning
     * @data 2018/10/11
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getAssociationMember", method = RequestMethod.GET)
    public String getAssociationMember(){
        return associationService.getAssociationMember();
    }

    /**
     * 获得全部协会会员
     * @author Ning
     * @data 2018/10/11
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getAllMember", method = RequestMethod.GET)
    public String getAllMember(){
        return associationService.getAllMember();
    }



    /**
     * 获取协会新闻详细信息
     * @author hua
     * @date 2018/10/11
     * @param urlId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRobotNewsInf",method = RequestMethod.GET)
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
