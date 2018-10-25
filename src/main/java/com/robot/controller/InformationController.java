package com.robot.controller;

import com.robot.service.InformationService;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
     * 获取行业动态具体内容
     * @author hua
     * @date 2018/9/24
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findInformationInfo",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String findInformationInfo(int id){
        return informationService.findInformationInfo(id);
    }



    /**
     * 获取分页显示的行业动态
     * @author hua
     * @date 2018/10/17
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findInformationByPage",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8")
    public String findInformationByPage(Integer pageNum){
        return informationService.findInformationByPage(pageNum);
    }

    /**
     * 获取政策具体内容
     * @author hua
     * @date 2018/10/22
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPolicyInf",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String findPolicyInf(int id){
        return informationService.findPolicyInfo(id);
    }



    /**
     * 获取分页显示的政策
     * @author hua
     * @date 2018/10/17
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPolicyByPage",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8")
    public String findPolicyByPage(Integer pageNum){
        return informationService.findPolicyByPage(pageNum);
    }

    /**
     * 获取咨询热点具体内容
     * @author hua
     * @date 2018/10/23
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findHotspotInfo",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String findHotspotInfo(int id){
        return informationService.findHotspotInfo(id);
    }



    /**
     * 获取分页显示的咨询热点
     * @author hua
     * @date 2018/10/23
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findHotspotByPage",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8")
    public String findHotspotByPage(Integer pageNum){
        return informationService.findHotspotByPage(pageNum);
    }

    /**
     * 获取行业报告具体内容
     * @author hua
     * @date 2018/10/23
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findReportInfo",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String findReportInfo(int id){
        return informationService.findReportInfo(id);
    }



    /**
     * 获取分页显示的行业报告
     * @author hua
     * @date 2018/10/23
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findReportByPage",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8")
    public String findReportByPage(Integer pageNum){
        return informationService.findReportByPage(pageNum);
    }
}
