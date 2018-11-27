package com.robot.scrapy;

import com.robot.bean.SpiderStatus;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configurable
@Component
public class SpiderManager {

    private static final String OFWEEK_PROJECT = "OfWeek";
    private static final String GDROBOT_PROJECT = "GDRobot";

    @Value("#{'${GDRobotModels}'.split(',')}")
    private static List<String> GDRobot;
    @Value("#{'${OfWeekModels}'.split(',')}")
    private static List<String> OfWeek;

    public static Map<String, List<String>> getParamMap(){
        Map<String, List<String>> paramMap = new HashMap<>();
        paramMap.put(OFWEEK_PROJECT, OfWeek);
        paramMap.put(GDROBOT_PROJECT,GDRobot);
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
