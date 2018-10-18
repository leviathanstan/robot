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
     * 获取资讯文章具体内容
     * @author hua
     * @date 2018/9/24
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getInformationInf/{id}",method = RequestMethod.GET)
    public String getInformationInf(@PathVariable int id){
        return informationService.getInformationInfo(id);
    }



    /**
     * 获取分页显示的行业动态
     * @author hua
     * @date 2018/10/17
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getInformationByPage",method = RequestMethod.POST)
    public String getInformationByPage(@RequestParam Integer pageNum){
        return informationService.getInformation1ByPage(pageNum);
    }

}
