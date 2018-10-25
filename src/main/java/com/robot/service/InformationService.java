package com.robot.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.InformationDao;
import com.robot.entity.RobotNews;
import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hua
 * @date 2018/9/24
 */
@Service
public class InformationService {

    @Autowired
    private InformationDao informationDao;

    /**
     * 获取行业动态的具体内容
     *
     * @param id
     * @return
     * @author hua
     * @date 2018/9/24
     */
    public String findInformationInfo(int id) {
        RobotNews information = informationDao.findInformationInfo(id);
        if (information==null){
            return GsonUtil.getErrorJson();
        }
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        return GsonUtil.getSuccessJson(information);
    }

    /**
     * 获取行业动态的前八条
     *
     * @return
     * @author hua
     * @date 2018/10/17
     */
    public ArrayList<RobotNews> findInformationTop() {
        ArrayList<RobotNews> informations1 = informationDao.findInformationTop();
        return informations1;
    }

    public String findInformationByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, 12);
        List<RobotNews> informations = informationDao.findInformationByPage();
        PageInfo<RobotNews> pageInfo = new PageInfo<>(informations);
        for (RobotNews information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(RobotNews.class, "url"), pageInfo);
    }

    /**
     * 获取政策的具体内容
     *
     * @param id
     * @return
     * @author hua
     * @date 2018/10/22
     */
    public String findPolicyInfo(int id) {
        RobotNews information = informationDao.findPolicyInfo(id);
        if (information==null){
            return GsonUtil.getErrorJson();
        }
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        return GsonUtil.getSuccessJson(information);
    }

    /**
     * 获取政策的前12条
     *
     * @return
     * @author hua
     * @date 2018/10/22
     */
    public ArrayList<RobotNews> findPolicyTop() {
        ArrayList<RobotNews> informations1 = informationDao.findPolicyTop();
        return informations1;
    }

    /**
     * 获取分页显示的政策
     * @author hua
     * @date 2018/10/22
     * @param Num
     * @return
     */
    public String findPolicyByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, 12);
        List<RobotNews> informations = informationDao.findPolicyByPage();
        PageInfo<RobotNews> pageInfo = new PageInfo<>(informations);
        for (RobotNews information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(RobotNews.class,"url" ), pageInfo);
    }


    public String findHotspotInfo(int id) {
        RobotNews information = informationDao.findHotspotInfo(id);
        return GsonUtil.getSuccessJson(information);
    }

    public String findReportInfo(int id) {
        RobotNews information = informationDao.findReportInfo(id);
        return GsonUtil.getSuccessJson(information);
    }

    public ArrayList<RobotNews> findHotspotTop() {
        ArrayList<RobotNews> informations1 = informationDao.findHotspotTop();
        return informations1;
    }

    public ArrayList<RobotNews> findReportTop() {
        ArrayList<RobotNews> informations1 = informationDao.findReportTop();
        return informations1;
    }

    public String findHotspotByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, 12);
        List<RobotNews> informations = informationDao.findHotspotByPage();
        PageInfo<RobotNews> pageInfo = new PageInfo<>(informations);
        for (RobotNews information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(RobotNews.class, "url"), pageInfo);
    }

    public String findReportByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, 12);
        List<RobotNews> informations = informationDao.findReportByPage();
        PageInfo<RobotNews> pageInfo = new PageInfo<>(informations);
        for (RobotNews information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(RobotNews.class, "url"), pageInfo);
    }

}