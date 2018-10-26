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
    AssociationService associationService;
    @Autowired
    CompanyService companyService;
    @Autowired
    InformationService informationService;
    @Autowired
    ExpertService expertService;
    @Autowired
    ProductService productService;
    @Autowired
    TechnologyService technologyService;

    public String getIndex(){
        Map<String,Object> dataMap = new HashMap<>();
        //原机器人协会
        dataMap.put("news",associationService.getIndexNews());
        dataMap.put("members",associationService.getIndexMember());
        dataMap.put("memberNews", companyService.getIndexMemberNews());
        dataMap.put("notices",associationService.getIndexNotice());
        dataMap.put("information1",informationService.findInformationTop());
        dataMap.put("policy",informationService.findPolicyTop());
        dataMap.put("school",expertService.findAllUniversity());
        dataMap.put("experts",expertService.findAllExpert());
        dataMap.put("expertArts",expertService.findExpertArtTop());
        //企业
        dataMap.put("companyNews", companyService.getCompanyNews());
        dataMap.put("companyBrand", companyService.getCompanyBrand());
        dataMap.put("companyDynamics", companyService.getCompanyDynamics());
        //dataMap.put("memberDynamic",companyService.getIndexMemberDynamic());
        //资讯
        //dataMap.put("hotspot",informationService.findHotspotTop());
        dataMap.put("report",informationService.findReportTop());
        //技术
        //dataMap.put("case",technologyService.getIndexCase());
        dataMap.put("basic",technologyService.getIndexBasic());
        dataMap.put("science",technologyService.getIndexDiscuss());
        //产品
        dataMap.put("productEvaluation", productService.getProductEvaluation());
        dataMap.put("productLibrary", productService.getProductLibrary());
        dataMap.put("productNews",productService.getIndexNews());
        dataMap.put("productRecommend",productService.getIndexRecommend());
        return GsonUtil.getSuccessJson(dataMap);
    }

}
