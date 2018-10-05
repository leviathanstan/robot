package com.robot.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.InformationDao;
import com.robot.entity.Information;
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
     * 获取资讯文章的具体内容
     * @author hua
     * @date 2018/9/24
     * @param id
     * @return
     */
    public String getInformationInfo(int id){
        Information information = informationDao.findInformationInfo(id);
        return GsonUtil.getSuccessJson(information);
    }

    /**
     * 获取指定类别的资讯文章的前八条
     * @author hua
     * @date 2018/9/27
     * @param categoryId
     * @return
     */
    public String getInformationTop(Integer categoryId){
        ArrayList<Information> informations = informationDao.findInformationTop(categoryId);
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class,"content","summary","link"),informations);
    }

    /**
     * 获取指定类型的所有资讯文章(分页)
     * @author hua
     * @date 2018/9/27
     * @param categoryId
     * @param pageNum
     * @return
     */
    public String getInformationByPage(Integer categoryId,Integer pageNum){
        PageHelper.startPage(pageNum,12);
        List<Information> informations = informationDao.findInformationByPage(categoryId);
        //PageInfo<Information> pageInfo = new PageInfo<>(informations);
        Map dataMap = new HashMap();
        dataMap.put("informations",informations);
        //dataMap.put("pageInfo",pageInfo);
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class,"link","content"),dataMap);
    }

    /**
     * 获取所有类别的资讯文章的前八条
     * @author hua
     * @data 2018/10/5
     * @return
     */
    public String getAllInformationTop(){
        ArrayList<Information> inf1 = informationDao.findInformationTop(1);
        ArrayList<Information> inf2= informationDao.findInformationTop(2);
        ArrayList<Information> inf3 = informationDao.findInformationTop(3);
        ArrayList<Information> inf4 = informationDao.findInformationTop(4);
        Map dataMap = new HashMap();
        dataMap.put("inf1",inf1);
        dataMap.put("inf2",inf2);
        dataMap.put("inf3",inf3);
        dataMap.put("inf4",inf4);
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class,"link","summary","content"),dataMap);
    }
}
