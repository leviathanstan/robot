package com.robot.scrapy;

import com.google.gson.reflect.TypeToken;
import com.robot.bean.SpiderStatus;
import com.robot.util.GsonUtil;
import com.robot.util.LogHelper;
import com.robot.util.PostUrlUtil;

import java.util.HashMap;
import java.util.Map;

public class Spider {
//    private static  String baseUrl = "http://120.78.74.103:6800";
    private static  String baseUrl = "http://127.0.0.1:6800";

    public static SpiderStatus listprojects()  {
        String url = baseUrl + "/listprojects.json";
        String result = PostUrlUtil.sendGet(url, null);
        LogHelper.scheduleTaskLog.info(result);
        return  getStatus(result);
    }

    public static SpiderStatus runSpider(String project, String spider)  {
        String url = baseUrl + "/schedule.json";
        SpiderManager.getParamMap();
        Map<String, String> params = new HashMap<>();
        params.put("project", project);
        params.put("spider", spider);
        System.out.println("url:" + url);
        String result = PostUrlUtil.sendPost(url, params, "utf-8");
        System.out.println(result);
        return getStatus(result);
    }

    public static SpiderStatus getStatus(String jsonResult){
        if (jsonResult != null){
            return GsonUtil.getGson().fromJson(jsonResult, new TypeToken<SpiderStatus>() {}.getType());
        }else {
            return null;
        }
    }

    public static Boolean isStatusError(SpiderStatus status){
        if (status != null && status.getStatus() != null && status.getStatus().equals("ok")){
            return false;
        }else {
            return true;
        }
    }
}
