package com.robot.service;

import com.robot.dao.DemandDao;
import com.robot.entity.Demand;
import com.robot.entity.User;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by 聪 on 2018/1/22
 */
@Service
public class DemandService {

    private static int PAGE_COUNT = 12;

    @Autowired
    private DemandDao demandDao;

    public String getAllDemandNums(){
        int count = demandDao.getAllDemandNums();
        return GsonUtil.getSuccessJson(count);
    }

    public String getAllDemands(int currentPage){
        int num = (currentPage-1)*PAGE_COUNT;
        List<Demand> demands = demandDao.getAllDemands(num);
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Demand.class,"dmdArea","dmdType","dmdContent",
                "dmdContact","dmdContactPublished","dmdCategoryId",
                User.class,"email","password","phone","permissions","role","status"),demands);
    }

    public String findDemandNums(int dmdType,int dmdCategoryId,String content){
        int count;
        if(content == null || content.equals("")){
            return GsonUtil.getErrorJson("查询内容不能为空！");
        }
        if(dmdCategoryId == 0){
            count = demandDao.findDemandNums(dmdType,content);
        }else {
            count = demandDao.findDemandNumsByCategory(dmdType,dmdCategoryId,content);
        }
        return GsonUtil.getSuccessJson(count);
    }

    public String findDemand(int dmdType,int dmdCategoryId,String content,int currentPage){
        int num = (currentPage - 1)*PAGE_COUNT;
        List<Demand> demands = new ArrayList<>();
        if(dmdCategoryId == 0){
            demands = demandDao.findDemand(dmdType,content,num);
        }else {
            demands = demandDao.findDemandByCategory(dmdType,dmdCategoryId,content,num);
        }
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Demand.class,"dmdArea","dmdType","dmdContent",
                "dmdContact","dmdContactPublished","dmdCategoryId","user"),demands);
    }

    public String getUserDemandNums(int id){
        int count = demandDao.getUserDemandNums(id);
        return GsonUtil.getSuccessJson(count);
    }

    public String getUserDemands(int id,int currentPage){
        int num = (currentPage-1)*PAGE_COUNT;
        List<Demand> demands = demandDao.getUserDemands(id,num);
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Demand.class,"dmdArea","dmdType","dmdContent",
                "dmdContact","dmdContactPublished","dmdCategoryId","user"),demands);
    }

    public String getDemand(int dmdId){
        Demand demand = demandDao.getDemand(dmdId);
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(Demand.class,"dmdSummary",User.class,"email","password","phone","permissions","role","status"),demand);
    }

    @Transactional
    public String saveDemand(Demand demand) {
        if(demand.getDmdTitle() == null || demand.getDmdTitle().equals("")){
            return GsonUtil.getErrorJson("标题不能为空！");
        }
        if(demand.getDmdContent() == null || demand.getDmdContent().equals("")){
            return GsonUtil.getErrorJson("内容不能为空！");
        }
        if(demand.getDmdContact() == null || demand.getDmdContact().equals("")){
            return GsonUtil.getErrorJson("联系方式不能为空！");
        }
        demand.setDmdTime(new Date());
        boolean success = demandDao.saveDemand(demand);
        if(success){
            return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(User.class,"email","password","phone","permissions","role","status"),demand);
        }
        return GsonUtil.getErrorJson();
    }
}
