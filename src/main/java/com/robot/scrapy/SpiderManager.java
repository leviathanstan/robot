package com.robot.scrapy;

import com.robot.bean.SpiderStatus;
import com.robot.util.LogHelper;
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
    private static final String GDEI_PROJECT = "GDei";
    private static final String GDSTC_PROJECT = "GDstc";
    private static final String GZII_PROJECT = "GZii";
    private static final String ROBOTCHINA_PROJECT = "RobotChina";

    private static List<String> GDRobot;
    private static List<String> OfWeek;
    private static List<String> GDei;
    private static List<String> GDstc;
    private static List<String> GZii;
    private static List<String> RobotChina;

    public static Map<String, List<String>> getParamMap(){
        Map<String, List<String>> paramMap = new HashMap<>();
        paramMap.put(OFWEEK_PROJECT, OfWeek);
        paramMap.put(GDROBOT_PROJECT,GDRobot);
        paramMap.put(GDEI_PROJECT,GDei);
        paramMap.put(GDSTC_PROJECT,GDstc);
        paramMap.put(GZII_PROJECT,GZii);
        paramMap.put(ROBOTCHINA_PROJECT,RobotChina);
        return paramMap;
    }

    public static List<SpiderStatus> runSpider(){
        Map<String, List<String>> paramMap = SpiderManager.getParamMap();
        List<SpiderStatus> spiderStatuses = new ArrayList<>();
        for (String project : paramMap.keySet()){
            for(String spider : paramMap.get(project)){
                if (spider!=null&&!spider.equals("")) {
                    LogHelper.scheduleTaskLog.info("开始调用" + project + "->" + spider);
                    spiderStatuses.add(Spider.runSpider(project, spider));
                }
            }
        }
        return spiderStatuses;
    }

    public List<String> getGDRobot() {
        return GDRobot;
    }

    @Value("#{'${GDRobotModels}'.split(',')}")
    public void setGDRobot(List<String> GDRobot) {
        SpiderManager.GDRobot = GDRobot;
    }

    public List<String> getOfWeek() {
        return OfWeek;
    }

    @Value("#{'${OfWeekModels}'.split(',')}")
    public void setOfWeek(List<String> ofWeek) {
        OfWeek = ofWeek;
    }

    public List<String> getGDei() {
        return GDei;
    }

    @Value("#{'${GDeiModels}'.split(',')}")
    public void setGDei(List<String> GDei) {
        SpiderManager.GDei = GDei;
    }

    public List<String> getGDstc() {
        return GDstc;
    }

    @Value("#{'${GDstcModels}'.split(',')}")
    public void setGDstc(List<String> GDstc) {
        SpiderManager.GDstc = GDstc;
    }

    public List<String> getGZii() {
        return GZii;
    }

    @Value("#{'${GZiiModels}'.split(',')}")
    public void setGZii(List<String> GZii) {
        SpiderManager.GZii = GZii;
    }

    public List<String> getRobotChina() {
        return RobotChina;
    }

    @Value("#{'${RobotChinaModels}'.split(',')}")
    public void setRobotChina(List<String> robotChina) {
        RobotChina = robotChina;
    }
}
