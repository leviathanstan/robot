package com.robot.service;

import com.google.gson.Gson;
import com.robot.dao.AssociationDao;
import com.robot.entity.RobotNews;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Ning
 * @date 2018/10/11
 */
@Service
public class AssociationService {
    @Autowired
    private AssociationDao associationDao;

    /**
     * 获取协会新闻详细信息
     * @author hua
     * @date 2018/10/11
     * @param urlId
     * @return
     */
    public String getRobotNewsInf(String urlId){
        RobotNews robotNews = associationDao.getRobotNewsInf(urlId);
        if(robotNews != null)
        return GsonUtil.getSuccessJson(robotNews);
        else
            return GsonUtil.getErrorJson();
    }

    /**
     * 获取协会新闻最新九条
     * @return
     */
    public String getRobotNewsTop(){
        ArrayList robotNews = associationDao.getRobotNewsTop();
        return GsonUtil.getSuccessJson(robotNews);
    }
}
