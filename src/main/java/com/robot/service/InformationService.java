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
     * 获取资讯文章的具体内容
     *
     * @param id
     * @return
     * @author hua
     * @date 2018/9/24
     */
    public String getInformationInfo(int id) {
        Information information = informationDao.findInformationInfo(id);
        return GsonUtil.getSuccessJson(information);
    }

//    /**
//     * 获取指定类别的资讯文章的前八条
//     *
//     * @param categoryId
//     * @return
//     * @author hua
//     * @date 2018/9/27
//     */
//    public ArrayList<Information> getInformationTop(Integer categoryId) {
//        ArrayList<Information> informations = informationDao.findInformationTop(categoryId);
//        return informations;
//    }
//
//    /**
//     * 获取指定类型的所有资讯文章(分页)
//     *
//     * @param categoryId
//     * @param pageNum
//     * @return
//     * @author hua
//     * @date 2018/9/27
//     */
//    public String getInformationByPage(Integer categoryId, Integer pageNum) {
//        PageHelper.startPage(pageNum, 12);
//        List<Information> informations = informationDao.findInformationByPage(categoryId);
//        //PageInfo<Information> pageInfo = new PageInfo<>(informations);
//        Map dataMap = new HashMap();
//        dataMap.put("informations", informations);
//        //dataMap.put("pageInfo",pageInfo);
//        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class, "link", "content"), dataMap);
//    }

    /**
     * 获取行业动态的前八条
     * @author hua
     * @date 2018/10/17
     * @return
     */
    public ArrayList<Information> getInformation1Top() {
        ArrayList<Information> informations1 = informationDao.findInformation1Top();
        return informations1;
    }

    public String getInformation1ByPage(Integer pageNum){
        PageHelper.startPage(pageNum, 12);
        List<Information> informations = informationDao.findInformation1ByPage();
        for(Information information:informations){
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }
        Map dataMap = new HashMap();
        dataMap.put("informations", informations);

        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Information.class, "link", "content"), dataMap);
    }
}
