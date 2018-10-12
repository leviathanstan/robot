package com.robot.controller;

import com.robot.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/noticeDetail")
    public String showDetail(String id, ModelMap modelMap) {
        modelMap.addAttribute("noticeId", id);
        return "notice_detail";
    }

    @ResponseBody
    @RequestMapping(value = "/getNoticeInfo" ,method = RequestMethod.GET)
    public String getNoticeInfo(@RequestParam("noticeId") String noticeId){
        return associationService.getNoticeInfo(noticeId);
    }
}