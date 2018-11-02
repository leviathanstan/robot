package com.robot.service;

import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author asce
 * @date 2018/10/12
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

}
