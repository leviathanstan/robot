package com.robot.controller;

import com.robot.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
     * 获得协会会员列表
     * @author Ning
     * @data 2018/10/11
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getMemberList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getMemberList(@RequestParam Integer pageNum){
        return associationService.getMemberList(pageNum);
    }

    /**
     * 根据memberId获得会员具体信息
     * @author Ning
     * @data 2019/10/19
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/getMemberInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getMemberInfo(@RequestParam Integer memberId){
        return associationService.getMemberInfo(memberId);
    }


    /**
     * 获取协会新闻详细信息
     * @author hua
     * @date 2018/10/11
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRobotNewsInf",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getRobotNewsInf(String id){
        return associationService.getRobotNewsInf(id);
    }


    @ResponseBody
    @RequestMapping(value = "/getNoticeInfo" ,method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getNoticeInfo(@RequestParam("id") String id){
        return associationService.getNoticeInfo(id);
    }
    /**
     * 搜索公告、more公告
     * @author asce
     * @date 2018/10/15
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getNoticeList" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String getNoticeList(@RequestParam Map<String,String> args){
        return associationService.getNotice(args);
    }
    /**
     * 搜索新闻，more新闻
     * @author asce
     * @date 2018/10/17
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getNewsList" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String getNewList(@RequestParam Map<String,String> args){
        return associationService.getNewsList(args);
    }
}
