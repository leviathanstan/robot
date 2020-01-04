package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.entity.Introduction;
import com.robot.entity.User;
import com.robot.enums.Role;
import com.robot.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author asce
 * @date 2018/11/2
 */
@RequestMapping(value = "/introduction")
@Controller
public class IntroductionController {

    @Autowired
    private IntroductionService introductionService;

    /**
     * 专家具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getExpertInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getExpertInfo(String id){
        return introductionService.getExpertInfo(id);
    }

    /**
     * 高校具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUniversityInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getUniversityInfo(String id){
        return introductionService.getUniversityInfo(id);
    }

    /**
     * 专家列表
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getExpertList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getExpertList(String pageNum){
        return introductionService.getExpertList(pageNum);
    }

    /**
     * 高校列表
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUniversityList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getUniversityList(String pageNum){
        return introductionService.getUniversityList(pageNum);
    }

    /**
     * 会员列表
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getMemberList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getMemberList(String pageNum){
        return introductionService.getMemberList(pageNum);
    }

    /**
     * 会员具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getMemberInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getMemberInfo(int id){
        return introductionService.getMemberInfo(id);
    }

    /**
     * 删除专家，高校，协会会员
     * @param ids
     * @return
     */
    @Authority(role = Role.MEMBER_NORMAL)
    @ResponseBody
    @RequestMapping(value = "manager/deleteIntroduction", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String deleteIntroduction(@RequestParam List<Integer> ids){
        return introductionService.deleteIntroduction(ids);
    }

    /**
     * 修改专家，高校，协会会员
     * @param introduction
     * @return
     */
    @Authority(role = Role.MEMBER_NORMAL)
    @ResponseBody
    @RequestMapping(value = "manager/updateIntroduction", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateIntroduction(Introduction introduction){
        return introductionService.updateIntroduction(introduction);
    }
    /**
     * 添加专家，高校，协会会员
     * @param introduction
     * @return
     */
    @Authority(role = Role.MEMBER_NORMAL)
    @ResponseBody
    @RequestMapping(value = "manager/addIntroduction", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addIntroduction(@SessionAttribute("user") User user, Introduction introduction){
        return introductionService.addIntroduction(introduction,user);
    }
}
