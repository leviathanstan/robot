package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.IntroductionDao;
import com.robot.entity.Introduction;
import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import com.robot.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author asce
 * @date 2018/11/2
 */
@Service
public class IntroductionService {

    @Autowired
    private IntroductionDao introductionDao;
    /**
     * introduction类别
     */
    private enum IntroductionEnum {
        EXPERT(16), UNIVERSITIES(17), MEMBER(18);
        private final int id;
        IntroductionEnum(int id) {
            this.id = id;
        }
        public int getId(){
            return id;
        }
    }
    /**
     * introduction 首页数量
     */
    private enum NumberEnum{
        EXPERT(10), UNIVERSITIES(10), MEMBER(10);
        private final int number;
        NumberEnum(int number) {
            this.number = number;
        }
        public int getNumber(){
            return number;
        }
    }
    private final int PAGE_LENGTH = 8;


    /**
     * 获取专家具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    public String getExpertInfo(String id){
        int infoId;
        if ((infoId=CommonUtil.formatPageNum(id))==0)   return GsonUtil.getErrorJson();
        Introduction expert = introductionDao.findIntroductionInfo(infoId);
        if (expert==null){
            return GsonUtil.getErrorJson();
        }
        expert.setIntroduction(CommonUtil.getAbsolutePath(expert.getIntroduction()));
        return GsonUtil.getSuccessJson(expert);
    }

    /**
     * 获取高校具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    public String getUniversityInfo(String id){
        int infoId;
        if ((infoId=CommonUtil.formatPageNum(id))==0)   return GsonUtil.getErrorJson();
        Introduction university = introductionDao.findIntroductionInfo(infoId);
        if (university==null){
            return GsonUtil.getErrorJson();
        }
        university.setIntroduction(CommonUtil.getAbsolutePath(university.getIntroduction()));
        return GsonUtil.getSuccessJson(university);
    }

    /**
     * 首页专家
     * @author hua
     * @date 2018/10/15
     * @return
     */
    public List<Introduction> getIndexExpert(){
        Map<String,Integer> map = new HashMap<>();
        map.put("categoryId", IntroductionEnum.EXPERT.getId());
        map.put("number",NumberEnum.EXPERT.getNumber());
        return introductionDao.getIndexIntroduction(map);
    }

    /**
     * 首页高校
     * @author hua
     * @date 2018/10/15
     * @return
     */
    public List<Introduction> getIndexUniversity(){
        Map<String,Integer> map = new HashMap<>();
        map.put("categoryId", IntroductionEnum.UNIVERSITIES.getId());
        map.put("number",NumberEnum.UNIVERSITIES.getNumber());
        return introductionDao.getIndexIntroduction(map);
    }

    /**
     * 获取专家的分页显示
     * @author hua
     * @date 2018/10/20
     * @param page
     * @return
     */
    public String getExpertList(String page){
        int pageNum = CommonUtil.formatPageNum(page);
        PageHelper.startPage(pageNum,PAGE_LENGTH);
        ArrayList<Introduction> experts = introductionDao.getIntroductionList(IntroductionEnum.EXPERT.getId());
        PageInfo<Introduction> pageInfo = new PageInfo<>(experts);
        for(Introduction expert:experts){
            expert.setIntroduction(CommonUtil.getPreview(expert.getIntroduction()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 获取高校的分页显示
     * @author hua
     * @date 2018/10/20
     * @param page
     * @return
     */
    public String getUniversityList(String page){
        int pageNum = CommonUtil.formatPageNum(page);
        PageHelper.startPage(pageNum,PAGE_LENGTH);
        ArrayList<Introduction> schools = introductionDao.getIntroductionList(IntroductionEnum.UNIVERSITIES.getId());
        PageInfo<Introduction> pageInfo = new PageInfo<>(schools);
        for(Introduction school:schools){
            school.setIntroduction(CommonUtil.getPreview(school.getIntroduction()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 首页协会成员
     */
    public List<Introduction> getIndexMember() {
        Map<String,Integer> map = new HashMap<>();
        map.put("categoryId", IntroductionEnum.MEMBER.getId());
        map.put("number",NumberEnum.MEMBER.getNumber());
        return introductionDao.getIndexIntroduction(map);
    }

    /**
     * 分页获得成员信息
     */
    public String getMemberList(String pageNum) {
        int page = CommonUtil.formatPageNum(pageNum);
        PageHelper.startPage(page,PAGE_LENGTH);
        List<Introduction> members = introductionDao.getIntroductionList(IntroductionEnum.MEMBER.getId());
        PageInfo<Introduction> pageInfo = new PageInfo<>(members);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 获得具体成员信息
     */
    public String getMemberInfo(String id){
        int infoId;
        if ((infoId=CommonUtil.formatPageNum(id))==0)   return GsonUtil.getErrorJson();
        Introduction member = introductionDao.findIntroductionInfo(infoId);
        if(member==null){
            return GsonUtil.getErrorJson();
        }
        member.setIntroduction(CommonUtil.getAbsolutePath(member.getIntroduction()));
        return GsonUtil.getSuccessJson(member);
    }

    /**
     * 删除专家、高校、协会成员
     * @param id
     * @return
     */
    public String deleteIntroduction(String id){
        int infoId;
        if ((infoId=CommonUtil.formatPageNum(id))==0)   return GsonUtil.getErrorJson();
        if(1!=introductionDao.delete(infoId))
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson();
    }

    /**
     * 修改专家、高校、协会成员
     * @param introduction
     * @return
     */
    public String updateIntroduction(Introduction introduction){
        if(ValidateUtil.isInvalidString(introductionDao.findIntroductionById(introduction.getId())))
            return GsonUtil.getErrorJson("修改内容不存在");
        if(introductionDao.update(introduction)<1)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson();
    }

    /**
     * 添加专家、高校、协会成员
     * @param introduction
     * @return
     */
    public String addIntroduction(Introduction introduction){
        if(ValidateUtil.isInvalidString(introduction.getIntroduction())||ValidateUtil.isInvalidString(introduction.getName())||ValidateUtil.isInvalidString(Integer.toString(introduction.getCategoryId())))
            return GsonUtil.getErrorJson("添加内容不完整");

        if(1!=introductionDao.add(introduction))
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson();
    }
}
