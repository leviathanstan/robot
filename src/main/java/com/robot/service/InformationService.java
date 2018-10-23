package com.robot.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.InformationDao;
import com.robot.entity.Information;
import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Information information = informationDao.findInformationInfo(id);
        return GsonUtil.getSuccessJson(information);
    }

    /**
     * 获取行业动态的前八条
     *
     * @return
     * @author hua
     * @date 2018/10/17
     */
    public ArrayList<Information> findInformationTop() {
        ArrayList<Information> informations1 = informationDao.findInformationTop();
        return informations1;
    }

    public String findInformationByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, 12);
        List<Information> informations = informationDao.findInformationByPage();
        PageInfo<Information> pageInfo = new PageInfo<>(informations);
        for (Information information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class, "link", "summary", "type", "coverImg"), pageInfo);
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
        Information information = informationDao.findPolicyInfo(id);
        return GsonUtil.getSuccessJson(information);
    }

    /**
     * 获取政策的前12条
     *
     * @return
     * @author hua
     * @date 2018/10/22
     */
    public ArrayList<Information> findPolicyTop() {
        ArrayList<Information> informations1 = informationDao.findPolicyTop();
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
        List<Information> informations = informationDao.findPolicyByPage();
        PageInfo<Information> pageInfo = new PageInfo<>(informations);
        for (Information information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class, "link", "summary", "type", "coverImg"), pageInfo);
    }


    public String findHotspotInfo(int id) {
        Information information = informationDao.findHotspotInfo(id);
        return GsonUtil.getSuccessJson(information);
    }

    public String findReportInfo(int id) {
        Information information = informationDao.findReportInfo(id);
        return GsonUtil.getSuccessJson(information);
    }

    public ArrayList<Information> findHotspotTop() {
        ArrayList<Information> informations1 = informationDao.findHotspotTop();
        return informations1;
    }

    public ArrayList<Information> findReportTop() {
        ArrayList<Information> informations1 = informationDao.findReportTop();
        return informations1;
    }

    public String findHotspotByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, 12);
        List<Information> informations = informationDao.findHotspotByPage();
        PageInfo<Information> pageInfo = new PageInfo<>(informations);
        for (Information information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class, "link", "summary", "type", "coverImg"), pageInfo);
    }

    public String findReportByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, 12);
        List<Information> informations = informationDao.findReportByPage();
        PageInfo<Information> pageInfo = new PageInfo<>(informations);
        for (Information information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class, "link", "summary", "type", "coverImg"), pageInfo);
    }

}