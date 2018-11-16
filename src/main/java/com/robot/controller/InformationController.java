package com.robot.controller;

import com.robot.annotation.PermissionsCheck;
import com.robot.dao.InformationDao;
import com.robot.entity.RobotNews;
import com.robot.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author asce
 * @date 2018/11/11
 */
@Controller
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    /**
     * 获取行业动态具体内容
     * @author hua
     * @date 2018/9/24
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findInformationInfo",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String findInformationInfo(int id){
        return informationService.findInformationInfo(id);
    }

    /**
     * 获取分页显示的行业动态
     * @author hua
     * @date 2018/10/17
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findInformationByPage",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8")
    public String findInformationByPage(Integer pageNum){
        return informationService.findInformationByPage(pageNum);
    }

    /**
     * 获取政策具体内容
     * @author hua
     * @date 2018/10/22
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPolicyInf",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String findPolicyInf(int id){
        return informationService.findPolicyInfo(id);
    }

    /**
     * 获取分页显示的政策
     * @author hua
     * @date 2018/10/17
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPolicyByPage",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8")
    public String findPolicyByPage(Integer pageNum){
        return informationService.findPolicyByPage(pageNum);
    }

    /**
     * 获取资讯热点具体信息
     * @author hua
     * @date 2018/10/17
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getHotSpotInfo",method = RequestMethod.GET ,produces = "text/html;charset=UTF-8")
    public String getHostSpotList(String id){
        return informationService.findHotInfo(id);
    }

    /**
     * 专家智点列表
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getExpertArtList",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getExpertArtInfo(String pageNum){
        return informationService.getExpertArtList(pageNum);
    }
    /**
     * 专家智点具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findExpertArtInfo",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findExpertArtInfo(String id){
        return informationService.getExpertArtInfo(id);
    }

    /**
     * 企业新闻列表
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCompanyNewsList", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getCompanyNewsList(String pageNum){
        return informationService.getCompanyNewsList(pageNum);
    }

    /**
     * 企业新闻具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCompanyNewsInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getCompanyNewsInfo(String id){
        return informationService.getCompanyNewsInfo(id);
    }

    /**
     * 企业动态列表
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCompanyDynamicsList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getCompanyDynamicsList(String pageNum){
        return informationService.getCompanyDynamicsList(pageNum);
    }

    /**
     * 企业动态具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCompanyDynamicsInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getCompanyDynamicsInfo(String id){
        return informationService.getCompanyDynamicsInfo(id);
    }

    /**
     * 协会新闻具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAssociationNewsInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getAssociationNewsInfo(String id){
        return informationService.getAssociationNewsInfo(id);
    }

    /**
     * 协会新闻列表
     * @param pageaNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAssociationNewsList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getAssociationNewsList(String pageaNum){
        return informationService.getAssociationNewsList(pageaNum);
    }

    /**
     * 通知公告列表
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getNoticeList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getNotice(String pageNum){
        return informationService.getNoticeList(pageNum);
    }

    /**
     * 通知公告具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getNoticeInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getNoticeInfo(String id){
        return informationService.getNoticeInfo(id);
    }

    /**
     * 基础知识列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getBasicList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getBasicList(String pageNum){
        return informationService.getBasicList(pageNum);
    }

    /**
     * 基础知识具体信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getBasicInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getBasicInfo(String id){
        return informationService.getBasicInfo(id);
    }

    /***
     * 产品评测列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getEvaluateList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getEvaluateList(String pageNum){
        return informationService.getEvaluateList(pageNum);
    }

    /**
     * 产品评测具体信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getEvaluateInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getEvaluateInfo(String id){
        return informationService.getEvaluateInfo(id);
    }

    /**
     * 产品新闻列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getProductNewsList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getProductNewsList(String pageNum){
        return informationService.getProductNewsList(pageNum);
    }

    /**
     * 产品新闻具体信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getProductNewsInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getProductNewsInfo(String id){
        return informationService.getProductNewsInfo(id);
    }

    /**
     * 产品推荐列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getRecommendList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getRecommendList(String pageNum){
        return informationService.getRecommendList(pageNum);
    }

    /**
     * 产品推荐具体信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getRecommendInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getRecommendInfo(String id){
        return informationService.getRecommendInfo(id);
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
   // @PermissionsCheck(access = "manager")
    @ResponseBody
    @RequestMapping(value = "deleteInformation", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String deleteInformation(String id){
        return informationService.deleteInformation(id);
    }

    /**
     * 修改文章
     * @param robotNews
     * @return
     */
   // @PermissionsCheck(access = "manager")
    @ResponseBody
    @RequestMapping(value = "updateInformation", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updateInformation(RobotNews robotNews){
        return informationService.updateInformation(robotNews);
    }

    /**
     * 添加文章
     * @param robotNews
     * @return
     */
   // @PermissionsCheck(access = "manager")
    @ResponseBody
    @RequestMapping(value = "addInformation", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addInformation(RobotNews robotNews){
        return informationService.addInformation(robotNews);
    }
}
