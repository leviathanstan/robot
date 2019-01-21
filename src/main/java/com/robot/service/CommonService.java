package com.robot.service;

import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author asce
 * @date 2018/11/11
 */
@Service
public class CommonService {
    @Autowired
    CompanyService companyService;
    @Autowired
    InformationService informationService;
    @Autowired
    IntroductionService introductionService;
    @Autowired
    ProductService productService;
    @Autowired
    PositionService positionService;
    @Autowired
    ConferenceService conferenceService;

    private enum SearchEnum {
        INFORMATION(1),PRODUCT(2),INTRODUCTION(3);
        private final int number;

        SearchEnum(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
    /**
     * 首页
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    public String getIndex() throws InterruptedException{
        Map<String,Object> dataMap = new HashMap<>();
        //原机器人协会
        CommonUtil.getTime(null);
//        dataMap.put("news",informationService.getIndexAssociationNews());
//        dataMap.put("members",introductionService.getIndexMember());
//        dataMap.put("notices",informationService.getIndexNotice());
//        dataMap.put("information1",informationService.findInformationTop());
//        dataMap.put("policy",informationService.findPolicyTop());
//        dataMap.put("school",introductionService.getIndexUniversity());
//        dataMap.put("experts",introductionService.getIndexExpert());
//        dataMap.put("expertArts",informationService.getIndexExpertArt());
//        //企业
//        dataMap.put("companyNews", informationService.getCompanyNews());
//        dataMap.put("companyBrand", companyService.getCompanyBrand());
//        dataMap.put("companyDynamics", informationService.getCompanyDynamics());
//        //资讯
//        dataMap.put("hotspot",informationService.getIndexHot());
//        dataMap.put("report",informationService.findReportTop());
//        //技术
//        //dataMap.put("case",technologyService.getIndexCase());
//        dataMap.put("basic",informationService.getIndexBasic());
//        dataMap.put("science",informationService.getIndexDiscuss());
//        dataMap.put("educationTrain",informationService.getEducationTrain());
//        //产品
//        dataMap.put("productEvaluation", informationService.getIndexEvaluate());
//        dataMap.put("productLibrary", productService.getProductLibrary());
//        dataMap.put("productNews",informationService.getIndexProductNews());
//        dataMap.put("productRecommend",informationService.getIndexRecommend());
//        //招聘
//        dataMap.put("position", positionService.getIndex());
//        //会议
//        dataMap.put("conference",conferenceService.getIndexConference());
//        dataMap.put("metting", conferenceService.getIndexMetting());
//        //相关热点
//        dataMap.put("relatedHot",informationService.findIndexRelatedHot());
        final CountDownLatch countDownLatch = new CountDownLatch(4);
        new Thread(()->run1(dataMap,countDownLatch)).start();
        new Thread(()->run2(dataMap,countDownLatch)).start();
        new Thread(()->run3(dataMap,countDownLatch)).start();
        new Thread(()->run4(dataMap,countDownLatch)).start();
        countDownLatch.await();
        CommonUtil.getTime(null);
        return GsonUtil.getSuccessJson(dataMap);
    }

    private void run1(Map<String,Object> dataMap,CountDownLatch countDownLatch){
        CommonUtil.getTime(1);
        try {
            dataMap.put("news",informationService.getIndexAssociationNews());
            dataMap.put("members",introductionService.getIndexMember());
            dataMap.put("notices",informationService.getIndexNotice());
            dataMap.put("expertArts",informationService.getIndexExpertArt());
        } finally {
            countDownLatch.countDown();
        }
        CommonUtil.getTime(1);
    }

    private void run2(Map<String,Object> dataMap,CountDownLatch countDownLatch){
        CommonUtil.getTime(2);
        try {
            dataMap.put("information1",informationService.findInformationTop());
            dataMap.put("policy",informationService.findPolicyTop());
            dataMap.put("experts",introductionService.getIndexExpert());
            dataMap.put("school",introductionService.getIndexUniversity());
        } finally {
            countDownLatch.countDown();
        }
        CommonUtil.getTime(2);
    }

    private void run3(Map<String,Object> dataMap,CountDownLatch countDownLatch){
        CommonUtil.getTime(3);
        try {
            dataMap.put("companyNews", informationService.getCompanyNews());
            dataMap.put("companyBrand", companyService.getCompanyBrand());
            dataMap.put("companyDynamics", informationService.getCompanyDynamics());
            //资讯
            dataMap.put("hotspot",informationService.getIndexHot());
            dataMap.put("report",informationService.findReportTop());
            //技术
            //dataMap.put("case",technologyService.getIndexCase());
            dataMap.put("basic",informationService.getIndexBasic());
            dataMap.put("science",informationService.getIndexDiscuss());
            dataMap.put("educationTrain",informationService.getEducationTrain());
        } finally {
            countDownLatch.countDown();
        }
        CommonUtil.getTime(3);
    }

    private void run4(Map<String,Object> dataMap,CountDownLatch countDownLatch){
        CommonUtil.getTime(4);
        //产品
        try {
            dataMap.put("productEvaluation", informationService.getIndexEvaluate());
            dataMap.put("productLibrary", productService.getProductLibrary());
            dataMap.put("productNews",informationService.getIndexProductNews());
            dataMap.put("productRecommend",informationService.getIndexRecommend());
            //招聘
            dataMap.put("position", positionService.getIndex());
            //会议
            dataMap.put("conference",conferenceService.getIndexConference());
            dataMap.put("metting", conferenceService.getIndexMetting());
            //相关热点
            dataMap.put("relatedHot",informationService.findIndexRelatedHot());
        } finally {
            countDownLatch.countDown();
        }
        CommonUtil.getTime(4);
    }

    /**
     * 搜索
     * @param args
     * @return
     */
    public String find(HashMap<String,String> args) {
        String channel = args.get("channel");
        int channelOption = CommonUtil.formateParmNum(channel);
        SearchEnum searchEnum = getSearchEnum(channelOption);
        HashMap<String,Object> map = new HashMap<>();
        map.put("informationCount",informationService.getSearchCount(args.get("content")));
        map.put("productCount", productService.getSearchCount(args.get("content")));
        // TODO: 2018/11/15
        switch (searchEnum) {
            case INFORMATION:
                map.put("results",informationService.findInformation(args));
                map.put("informationCategoryCount",informationService.getCategoryCount(args.get("content")));
                break;
            case PRODUCT:
                map.put("results",productService.searchProduct(args));
                break;
            case INTRODUCTION:
                map.put("results",introductionService.search(args));
                break;
            default:
                break;
        }

        return GsonUtil.getSuccessJson(map);
    }
    /**
     * 根据values寻找对应枚举
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    private SearchEnum getSearchEnum(int option){
        SearchEnum[] searchEnums = SearchEnum.values();
        for(int i = 0; i< searchEnums.length;i++){
            if (searchEnums[i].getNumber()==option){
                return searchEnums[i];
            }
        }
        return SearchEnum.INFORMATION;
    }
    /**
     * 上传图片
     * @author asce
     * @date 2018/11/30
     * @param
     * @return
     */
    public String uploadImg(MultipartFile[] imgs){
        if(imgs == null || imgs.length == 0){
            return GsonUtil.getErrorJson("没有选择图片");
        }else{
            //返回结果
            List<String> path;
            if ((path = CommonUtil.saveImg(imgs)).size()!=0){
                return GsonUtil.getSuccessJson(path);
            }
        }
        return GsonUtil.getErrorJson("上传失败");
    }

    /**
     * 上传文件
     * @author asce
     * @date 2018/11/30
     * @param
     * @return
     */
    public String uploadFile(MultipartFile[] files){
        if(files == null || files.length == 0){
            return GsonUtil.getErrorJson("没有选择文件");
        }else{
            //返回结果
            List<String> path;
            if ((path = CommonUtil.saveFile(files)).size()!=0){
                return GsonUtil.getSuccessJson(path);
            }
        }
        return GsonUtil.getErrorJson("上传失败");
    }


}
