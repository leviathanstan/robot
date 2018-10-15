package com.robot.service;

import com.robot.dao.ExpertDao;
import com.robot.entity.Article;
import com.robot.entity.Expert;
import com.robot.entity.University;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hua
 * @date 2018/9/25
 */
@Service
public class ExpertService {

    @Autowired
    private ExpertDao expertDao;

    /**
     * 获取专家具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    public String findExpertInf(Integer id){
        Expert expert = expertDao.findExpertInf(id);
        return GsonUtil.getSuccessJson(expert);
    }

    /**
     * 获取高校具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    public String findUniversityInf(Integer id){
        University university = expertDao.findUniversityInf(id);
        return GsonUtil.getSuccessJson(university);
    }

    /**
     * 获取专家智点文章前八条
     * @author hua
     * @date 2018/9/27
     * @return
     */
    public String findExpertArtTop(){
        ArrayList<Article> articles = expertDao.findExpertArtTop();
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Article.class,"link","summary","content","source","type"),articles);
    }

    /**
     * 获取所有专家
     * @author hua
     * @date 2018/10/15
     * @return
     */
    public String findAllExpert(){
        return GsonUtil.getSuccessJson(expertDao.findAllExpert());
    }

    /**
     * 获取所有高校
     * @author hua
     * @date 2018/10/15
     * @return
     */
    public String findAllUniversity(){
        return GsonUtil.getSuccessJson(expertDao.findAllUniversity());
    }
}
