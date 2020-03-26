package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.entity.Demand;
import com.robot.entity.User;
import com.robot.enums.Role;
import com.robot.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * create by 聪 on 2018/1/22
 */
@Controller
@RequestMapping(value = "/demand")
public class DemandController {

    @Autowired
    private DemandService demandService;


    /**
     * 获取全部需求的数量
     * @return
     */
    @RequestMapping(value = "/getAllDemandNums")
    @ResponseBody
    public String getAllDemandNums(){
        return demandService.getAllDemandNums();
    }

    /**
     * 获取全部需求
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/getAllDemands")
    @ResponseBody
    public String getAllDemands(int currentPage){
        return demandService.getAllDemands(currentPage);
    }


    /**
     * 需求搜索(分页)
     * @param dmdType
     * @param dmdCategoryId
     * @param content
     * @return
     */
    @RequestMapping(value = "/findDemandNums")
    @ResponseBody
    public String findDemandNums(int dmdType,int dmdCategoryId,String content){
        return demandService.findDemandNums(dmdType,dmdCategoryId,content);
    }

    /**
     * 需求搜索
     * @param dmdType
     * @param dmdCategoryId
     * @param content
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/findDemand")
    @ResponseBody
    public String findDemand(int dmdType,int dmdCategoryId,String content,int currentPage){
        return demandService.findDemand(dmdType,dmdCategoryId,content,currentPage);
    }

    /**
     * 获取我的需求数量
     * @param
     * @return
     */
    @Authority(role = Role.NORMAL)
    @RequestMapping(value = "/getUserDemandNums")
    @ResponseBody
    public String getUserDemandNums(HttpSession session){
        User user = (User) session.getAttribute("user");
        return demandService.getUserDemandNums(user.getId());
    }

    /**
     * 获取我的需求发布
     * @param
     * @return
     */
    @Authority(role = Role.NORMAL)
    @RequestMapping(value = "/getUserDemands")
    @ResponseBody
    public String getUserDemands(HttpSession session,int currentPage){
        User user = (User) session.getAttribute("user");
        return demandService.getUserDemands(user.getId(),currentPage);
    }

    /**
     * 需求发布
     * @param demand
     * @return
     */
    @Authority(role = Role.NORMAL)
    @RequestMapping(value = "/saveDemand",method = RequestMethod.POST)
    @ResponseBody
    public String saveDemand(HttpSession session,Demand demand) {
        User user = (User) session.getAttribute("user");
        demand.setUser(user);
        return demandService.saveDemand(demand);
    }

    /**
     * 查看需求详情
     * @param dmdId
     * @return
     */
    @RequestMapping(value = "/getDemand",method = RequestMethod.GET)
    @ResponseBody
    public String getDemand(int dmdId){
        return demandService.getDemand(dmdId);
    }

}
