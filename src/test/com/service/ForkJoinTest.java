package com.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

/**
 * 尝试使用Fork/Join的工作密取
 *
 * @author asce
 * @date 2019/6/8
 */
public class ForkJoinTest extends RecursiveTask<ArrayList<Object>> {

    private Map<String,Object> dataMap;
    private final int size = 5;

    ForkJoinTest(Map<String,Object> map){
        this.dataMap = map;
    }

    @Override
    protected ArrayList<Object> compute(){
        ArrayList<ForkJoinTest> list = new ArrayList<>();
        if (dataMap.size() <= size){
            ArrayList<Object> robotNews = new ArrayList<>();
            for (Map.Entry<String,Object> entry:dataMap.entrySet()){
                Object object = entry.getValue();
                try {
                    Method method = object.getClass().getDeclaredMethod(entry.getKey());
                    method.setAccessible(true);
                    robotNews.addAll((ArrayList<Object>) method.invoke(object));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return robotNews;
        } else {
            int count = 0;
            Map<String, Object> subMap = new HashMap<>();
            for (Map.Entry<String, Object> map : dataMap.entrySet()) {
                count++;
                subMap.put(map.getKey(), map.getValue());
                if (subMap.size() >= size || count == dataMap.size()) {
                    ForkJoinTest forkJoin = new ForkJoinTest(subMap);
                    forkJoin.fork();
                    list.add(forkJoin);
                    subMap = new HashMap<>();
                }
            }
        }
        ArrayList<Object> robotNews = new ArrayList<>();
        for (ForkJoinTest forkJoinTest: list){
            robotNews.addAll(forkJoinTest.join());
        }
        return robotNews;
    }
}
