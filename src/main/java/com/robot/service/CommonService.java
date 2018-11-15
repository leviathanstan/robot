package com.robot.service;

import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    private enum SearchEnum {
        INFORMATION(1),PRODUCT(2),WORK(3);
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
    public String getIndex(){
        Map<String,Object> dataMap = new HashMap<>();
        //原机器人协会
        dataMap.put("news",informationService.getIndexAssociationNews());
        dataMap.put("members",introductionService.getIndexMember());
        dataMap.put("notices",informationService.getIndexNotice());
        dataMap.put("information1",informationService.findInformationTop());
        dataMap.put("policy",informationService.findPolicyTop());
        dataMap.put("school",introductionService.getIndexUniversity());
        dataMap.put("experts",introductionService.getIndexExpert());
        dataMap.put("expertArts",informationService.getIndexExpertArt());
        //企业
        dataMap.put("companyNews", informationService.getCompanyNews());
        dataMap.put("companyBrand", companyService.getCompanyBrand());
        dataMap.put("companyDynamics", informationService.getCompanyDynamics());
        //资讯
        dataMap.put("hotspot",informationService.getIndexHot());
        //dataMap.put("report",informationService.getIndexReport());
        //技术
        //dataMap.put("case",technologyService.getIndexCase());
        dataMap.put("basic",informationService.getIndexBasic());
        //dataMap.put("science",informationService.get());
        //产品
        dataMap.put("productEvaluation", informationService.getIndexEvaluate());
        dataMap.put("productLibrary", productService.getProductLibrary());
        dataMap.put("productNews",informationService.getIndexProductNews());
        dataMap.put("productRecommend",informationService.getIndexRecommend());
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     * 搜索
     * @param args
     * @return
     */
    public String find(HashMap<String,String> args) {
        String channel = args.get("channel");
        int channelOption = CommonUtil.formateParmNum(channel);
        switch (channelOption) {
//            case SearchEnum.INFORMATION.getNumber():
//
//                break;
//            case SearchEnum.PRODUCT.getNumber():
//
//                break;
//            case SearchEnum.WORK.getNumber():
//
//                break;
//        }


        }
        return GsonUtil.getSuccessJson();
    }
}
