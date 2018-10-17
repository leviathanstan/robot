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
    InformationService informationService;

    public String getIndex(){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("news",associationService.getIndexNews());
        dataMap.put("members",associationService.getIndexMember());
        dataMap.put("notices",associationService.getIndexNotice());
//        dataMap.put("informations1",informationService.getInformationTop(1));
//        dataMap.put("informations2",informationService.getInformationTop(2));
//        dataMap.put("informations3",informationService.getInformationTop(3));
//        dataMap.put("informations4",informationService.getInformationTop(4));
        return GsonUtil.getSuccessJson(dataMap);
    }

}
