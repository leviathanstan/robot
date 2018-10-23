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

    public String getIndex(){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("news",associationService.getIndexNews());
        dataMap.put("members",associationService.getIndexMember());
        dataMap.put("memberNews", companyService.getIndexMemberNews());
        dataMap.put("notices",associationService.getIndexNotice());
        dataMap.put("information1",informationService.findInformationTop());
        dataMap.put("policy",informationService.findPolicyTop());
        dataMap.put("school",expertService.findAllUniversity());
        dataMap.put("experts",expertService.findAllExpert());
        dataMap.put("expertArts",expertService.findExpertArtTop());
        dataMap.put("hotspot",informationService.findHotspotTop());
        dataMap.put("report",informationService.findReportTop());

        return GsonUtil.getSuccessJson(dataMap);
    }

}
