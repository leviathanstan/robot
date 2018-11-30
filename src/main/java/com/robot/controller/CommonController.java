package com.robot.controller;

import com.robot.schedule.ScheduleTask;
import com.robot.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping(value="/uploadImg",method = {RequestMethod.POST})
    @ResponseBody
    public String uploadImg(@RequestParam("imgs") MultipartFile[] file) throws Exception{
        return commonService.uploadImg(file);
    }

    @RequestMapping(value="/uploadFile",method = {RequestMethod.POST})
    @ResponseBody
    public String uploadFile(@RequestParam("files") MultipartFile[] file) throws Exception{
        return commonService.uploadFile(file);
    }
}
