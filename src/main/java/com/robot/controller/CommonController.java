package com.robot.controller;

import com.robot.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author asce
 * @date 2018/11/14
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    @Autowired
    CommonService commonService;

    @ResponseBody
    @RequestMapping(value = "/getIndex",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getIndex(){
        return commonService.getIndex();
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String search(@RequestParam HashMap args){
        return commonService.find(args);
    }
}
