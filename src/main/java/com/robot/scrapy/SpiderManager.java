package com.robot.scrapy;

import com.robot.bean.SpiderStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiderManager {
    // 项目
    private static final String NEWS= "RobotNews";
    private static final String CASE = "RobotCase";
    // 咨询模块
    private static final String NEWS_OFWEEK = "RobotOfweekNews";
    // 案例模块
    private static final String CASE_FANGAN = "RobotFananCase";

    public static Map<String, List<String>> getParamMap(){
        List<String> newsSpiders = new ArrayList<>();
        newsSpiders.add(NEWS_OFWEEK);
        List<String> caseSpiders = new ArrayList<>();
        caseSpiders.add(CASE_FANGAN);
        Map<String, List<String>> paramMap = new HashMap<>();
        paramMap.put(NEWS, newsSpiders);
        paramMap.put(CASE, caseSpiders);
        return paramMap;
    }

    public static List<SpiderStatus> runSpider(){
        Map<String, List<String>> paramMap = SpiderManager.getParamMap();
        List<SpiderStatus> spiderStatuses = new ArrayList<>();
        for (String project : paramMap.keySet()){
            for(String spider : paramMap.get(project)){
                spiderStatuses.add(Spider.runSpider(project, spider));
            }
        }
        return spiderStatuses;
    }

}
