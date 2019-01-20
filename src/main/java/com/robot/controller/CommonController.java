package com.robot.controller;

import com.robot.bean.SpiderStatus;
import com.robot.schedule.ScheduleTask;
import com.robot.scrapy.Spider;
import com.robot.scrapy.SpiderManager;
import com.robot.service.CommonService;
import com.robot.util.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.List;

/**
 * @author asce
 * @date 2018/11/14
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    @Autowired
    CommonService commonService;
    @Autowired
    ScheduleTask scheduleTask;
    @Autowired
    private SpiderManager spiderManager;

    @ResponseBody
    @RequestMapping(value = "/getIndex",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getIndex() throws InterruptedException{
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

    @RequestMapping(value = "/runSpider",method = RequestMethod.GET)
    public String runSpider(){
        try {
            LogHelper.scheduleTaskLog.info("启动爬虫...");
            SpiderStatus status = Spider.listprojects();
            if (Spider.isStatusError(status)) {
                if (status != null){
                    LogHelper.scheduleTaskLog.error("状态异常：" + status.stackTrace());
                }
                throw new ConnectException("爬虫状态异常");
            }
            if (status.getProjects().contains("OfWeek")) {
                List<SpiderStatus> spiderStatuses = spiderManager.runSpider();
                if (Spider.isStatusError(status)) {
                    LogHelper.scheduleTaskLog.error("爬虫状态异常：" + status.stackTrace());
                }
            } else {
                LogHelper.scheduleTaskLog.error("当前项目列表中没有目标爬虫。");
            }
        }catch (ConnectException e){
            LogHelper.scheduleTaskLog.error("连接不上scrapyd服务器！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }

}
