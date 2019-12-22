package com.service;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author asce
 * @date 2019/12/22
 */
public class ExecutorTest {

    private ExecutorService es = Executors.newFixedThreadPool(8);

    public List<Object> doIt(Map<String, Object> dataMap) {
        List<FutureTask<ArrayList<Object>>> futureTasks = new ArrayList<>();
        Map<String,Object> subMap = new HashMap<>();
        int count = 0;
        for (Map.Entry<String,Object> map: dataMap.entrySet()){
            count++;
            subMap.put(map.getKey(), map.getValue());
            if (subMap.size() >= 5 || count == dataMap.size()) {
                FutureTask<ArrayList<Object>> task = new FutureTask<>(new Jobable(subMap));
                es.execute(task);
                futureTasks.add(task);
                subMap = new HashMap<>();
            }
        }
        ArrayList<Object> result = new ArrayList<>();
        for (FutureTask<ArrayList<Object>> futureTask:futureTasks){
            //异常处理（不晓得怎么处理）
            try {
                result.addAll(futureTask.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        }
        return result;
    }

    class Jobable implements Callable<ArrayList<Object>> {

        private Map<String,Object> dataMap;

        Jobable(Map<String,Object> map){
            this.dataMap = map;
        }

        @Override
        public ArrayList<Object> call() throws Exception{
            ArrayList<Object> robotNews = new ArrayList<>();
            for (Map.Entry<String,Object> entry:dataMap.entrySet()){
                Object object = entry.getValue();
                Method method = object.getClass().getDeclaredMethod(entry.getKey());
                method.setAccessible(true);
                robotNews.addAll((ArrayList<Object>) method.invoke(object));
            }
            return robotNews;
        }
    }
}
