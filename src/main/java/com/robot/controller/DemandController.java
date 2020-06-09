package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.entity.Bidding;
import com.robot.entity.Demand;
import com.robot.entity.User;
import com.robot.enums.Role;
import com.robot.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * create by 聪 on 2018/1/22
 */
@Controller
@RequestMapping(value = "/demand")
public class DemandController {

    @Autowired
    private DemandService demandService;


    /**
     * 分页获取需求或供应、搜索
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllDemands", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllDemands(int type, int pageNum, String keyword){
        return demandService.getDemands(type, pageNum, keyword, null);
    }


    /**
     * 分页获取我的需求或供应、搜索
     * @param
     * @return
     */
    @Authority(role = Role.NORMAL)
    @RequestMapping(value = "/getUserDemands", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getUserDemands(HttpSession session, int type, int pageNum, String keyword){
        User user = (User) session.getAttribute("user");
        return demandService.getDemands(type, pageNum, keyword, user.getId());
    }

    /**
     * 查看需求或供应详情
     * @param
     * @return
     */
    @RequestMapping(value = "/getDemand",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDemand(int id){
        return demandService.getDemand(id);
    }

    /**
     * 发布需求或供应
     * @param demand
     * @return
     */
    @Authority(role = Role.NORMAL)
    @RequestMapping(value = "/saveDemand",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveDemand(HttpSession session, Demand demand) {
        User user = (User) session.getAttribute("user");
        demand.setUserId(user.getId());
        demand.setCreatTime(new Date());
        return demandService.saveDemand(demand);
    }

    /**
     * 投标
     * @Author  xm
     * @Date 2020/4/2 16:42
     * @param session
     * @param bidding
     * @param attachment
     * @return java.lang.String
     */
    @Authority(role = Role.NORMAL)
    @RequestMapping(value = "/bid",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String bid(HttpSession session, Bidding bidding, @RequestParam MultipartFile attachment) {
        User user = (User) session.getAttribute("user");
        bidding.setUserId(user.getId());
        return demandService.bid(bidding, attachment);
    }

    /**
     * 发布需求的人看投标信息
     * @Author  xm
     * @Date 2020/4/2 16:45 
     * @param session	
     * @param pageNum
     * @param demandId
     * @return java.lang.String
     */
    @Authority(role = Role.NORMAL)
    @RequestMapping(value = "/getBid",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getBid(HttpSession session, Integer pageNum, @RequestParam(required = false) Integer demandId) {
        User user = (User) session.getAttribute("user");
        return demandService.getBid(user.getId(), pageNum, demandId);
    }

    /**
     * 下载投标信息的附件
     * @Author  xm
     * @Date 2020/4/2 19:14 
     * @param session	
     * @param id
     * @return org.springframework.http.ResponseEntity<byte[]>
     */
    @Authority(role = Role.NORMAL)
    @RequestMapping(value = "/dowmloadAttachment",method = RequestMethod.GET)
    public ResponseEntity<byte[]> dowmloadAttachment(HttpSession session, Integer id) throws IOException {
        User user = (User) session.getAttribute("user");
        return demandService.dowmloadAttachment(user.getId(), id);
    }

}
