package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.enums.Role;
import com.robot.service.AboutusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Create 2020-05-19 19:21
 * @Author xm
 * @Description
 */
@Controller
@RequestMapping("/aboutus")
public class AboutusController {

    @Autowired
    private AboutusService aboutusService;

    /**
     * 获取关于我们
     * @Author  xm
     * @Date 2020/5/19 19:19
     * @param
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String getAboutus() {
        return aboutusService.getAboutus();
    }

    /**
     * 更新关于我们
     * @Author  xm
     * @Date 2020/5/19 19:21
     * @param content
     * @return java.lang.String
     */
    @ResponseBody
    @Authority(role = Role.MANAGER)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAboutus(String content) {
        return aboutusService.updateAboutus(content);
    }
}
