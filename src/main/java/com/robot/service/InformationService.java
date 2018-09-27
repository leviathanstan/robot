package com.robot.service;


import com.robot.dao.InformationDao;
import com.robot.entity.Information;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class,"content","summary","link","releaseTime"),informations);
    }
}
