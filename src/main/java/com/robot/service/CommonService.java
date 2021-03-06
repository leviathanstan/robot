package com.robot.service;

import com.robot.dao.AdDao;
import com.robot.dao.UserDao;
import com.robot.entity.User;
import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
    @Autowired
    MemberService memberService;
    @Autowired
    AdDao adDao;
    @Autowired
    DemandService demandService;
    @Autowired
    UserDao userDao;

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
    //设置sync = true后过期时间无法生效
    @Cacheable(value = "info", key = "'index'")//, sync = true)
    public String getIndex() throws InterruptedException{
        Map<String,Object> dataMap = new ConcurrentHashMap<>(35);
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->run1(dataMap,countDownLatch)).start();
        new Thread(()->run2(dataMap,countDownLatch)).start();
        new Thread(()->run3(dataMap,countDownLatch)).start();
        countDownLatch.await();
        return GsonUtil.getSuccessJson(dataMap);
    }

    private void run1(Map<String,Object> dataMap,CountDownLatch countDownLatch){
        try {
            //原机器人协会
            dataMap.put("news",informationService.getIndexAssociationNews());
            dataMap.put("members",introductionService.getIndexMember());
            dataMap.put("notices",informationService.getIndexNotice());
            dataMap.put("expertArts",informationService.getIndexExpertArt());
            dataMap.put("information1",informationService.findInformationTop());
            dataMap.put("policy",informationService.findPolicyTop());
            dataMap.put("school",introductionService.getIndexUniversity());
            dataMap.put("experts",introductionService.getIndexExpert());
        } finally {
            countDownLatch.countDown();
        }
    }

    private void run2(Map<String,Object> dataMap,CountDownLatch countDownLatch){
        try {
            //企业
            dataMap.put("companyNews", informationService.getCompanyNews());
            dataMap.put("companyBrand", companyService.getCompanyBrand());
            dataMap.put("companyDynamics", informationService.getCompanyDynamics());
            //资讯
            dataMap.put("hotspot",informationService.getIndexHot());
            dataMap.put("report",informationService.findReportTop());
            //技术
            dataMap.put("case",informationService.getIndexCase());
            dataMap.put("basic",informationService.getIndexBasic());
            dataMap.put("science",informationService.getIndexDiscuss());
            dataMap.put("educationTrain",informationService.getEducationTrain());
        } finally {
            countDownLatch.countDown();
        }
    }

    private void run3(Map<String,Object> dataMap,CountDownLatch countDownLatch){
        try {
            //产品
            dataMap.put("productEvaluation", informationService.getIndexEvaluate());
            dataMap.put("productLibrary", productService.getProductLibrary());
            dataMap.put("productNews",informationService.getIndexProductNews());
            dataMap.put("productRecommend",informationService.getIndexRecommend());
            //招聘
            dataMap.put("position", positionService.getIndex());
            //会议
            dataMap.put("conference",conferenceService.getIndexConference());
            dataMap.put("meeting", conferenceService.getIndexMetting());
            dataMap.put("other",conferenceService.getOther());
            //相关热点
            dataMap.put("relatedHot",informationService.findIndexRelatedHot());
            //广告
            dataMap.put("ad", adDao.selectByExample(null));
            //供应
            dataMap.put("demand0", demandService.getIndexDemands(0));
            //需求
            dataMap.put("demand1", demandService.getIndexDemands(1));
        } finally {
            countDownLatch.countDown();
        }
    }
    /**
     * 数据汇总
     * @Author  xm
     * @Date 2020/6/17 13:42
     * @param
     * @return java.lang.String
     */
    @Cacheable("count")
    public String count() {
        Map map = new HashMap(7);

        //资讯数量
        Integer informationCount = informationService.countInformation();

        //行业报告数量
        Integer reportCount = informationService.countInformation();

        //政策数量
        Integer policyCount = informationService.countPolicy();

        //产品数量
        Integer productCount = informationService.countProduct();
        Integer productLibraryCount = productService.count();

        //技术数量
        Integer technologyCount = informationService.countTechnology();
        Integer discuss = informationService.countDiscuss();

        //资讯
        map.put("information", informationCount + reportCount + policyCount);
        //政策
        map.put("policy", policyCount);
        //产品
        map.put("product", productCount + productLibraryCount);
        //技术
        map.put("technology", technologyCount + discuss);

        //用户数
        map.put("user", userDao.count());

        //分类统计企业数量
        List<Map> enterprises = userDao.countEnterpriseType();
        long enterpriseNum = 0;
        for (Map map1 : enterprises) {
            enterpriseNum += (long)map1.get("num");
        }
        map.put("enterprise", enterprises);
        map.put("enterprises", enterpriseNum);

        return GsonUtil.getSuccessJson(map);
    }

    /**
     * 搜索
     * @param args
     * @return
     */
    public String find(HashMap<String,String> args,User user) {
        String channel = args.get("channel");
        int channelOption = CommonUtil.formateParmNum(channel);
        SearchEnum searchEnum = getSearchEnum(channelOption);
        HashMap<String,Object> map = new HashMap<>();
        map.put("informationCount",informationService.getSearchCount(args.get("content")));
        map.put("productCount", productService.getSearchCount(args.get("content")));
        if(user != null) {
            args.put("userRole", user.getRole().toString());
            args.put("userId",user.getId().toString());
        }
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
    public String uploadFile(MultipartFile[] files) throws Exception{
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

    /**
     * 获取会员单位资讯信息等
     * @param id
     * @return
     */
    public String getMemberInfo(int id){
        return memberService.getMemberInfo(id);
    }

}
