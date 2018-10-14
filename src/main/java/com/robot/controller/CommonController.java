package com.robot.controller;

import com.robot.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author asce
 * @date 2018/10/12
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    CommonService commonService;

    @ResponseBody
    @RequestMapping(value = "/getIndex",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getIndex(){
        return commonService.getIndex();
    }
}
