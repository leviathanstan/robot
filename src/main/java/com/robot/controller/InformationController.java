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
    @RequestMapping(value = "/findInformationInfo/{id}",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String findInformationInfo(@PathVariable int id){
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
    @RequestMapping(value = "/findPolicyInf/{id}",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String findPolicyInf(@PathVariable int id){
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
}
