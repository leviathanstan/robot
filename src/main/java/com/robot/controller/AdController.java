package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.entity.Ad;
import com.robot.enums.Role;
import com.robot.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Create 2020-05-19 20:10
 * @Author xm
 * @Description 广告
 */
@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private AdService adService;

    /**
     * 增加广告
     * @Author  xm
     * @Date 2020/5/19 20:09
     * @param ad
     * @return java.lang.String
     */
    @ResponseBody
    @Authority(role = Role.MANAGER)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Ad ad) {
        return adService.add(ad);
    }

    /**
     * 修改广告
     * @Author  xm
     * @Date 2020/5/19 20:09
     * @param ad
     * @return java.lang.String
     */
    @ResponseBody
    @Authority(role = Role.MANAGER)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Ad ad) {
        return adService.update(ad);
    }

    /**
     * 删除广告
     * @Author  xm
     * @Date 2020/5/19 20:09
     * @param ids
     * @return java.lang.String
     */
    @ResponseBody
    @Authority(role = Role.MANAGER)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam List<Integer> ids) {
        return adService.delete(ids);
    }

    /**
     * 获取广告
     * @Author  xm
     * @Date 2020/5/19 20:10
     * @param
     * @return java.lang.String
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        return adService.get();
    }
}
