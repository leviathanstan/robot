package com.robot.util;

import org.apache.commons.io.IOExceptionWithCause;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.concurrent.*;

public class PostUrlUtil {

    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    // 使用URLConnection发送post
    public static String sendPost(String urlParam, Map<String, String> paramsMap, String charset)  {
        String params = setParams(paramsMap);
        String result = null;
        // 构建请求参数
        URLConnection con = null;
        OutputStreamWriter osw = null;
        try {
            URL realUrl = new URL(urlParam);
            // 打开和URL之间的连接
            con = realUrl.openConnection();
            // 设置通用的请求属性
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            con.setDoOutput(true);
            con.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            osw = new OutputStreamWriter(con.getOutputStream(), charset);
            if (params != null && params.length() > 0) {
                // 发送请求参数
                osw.write(params);
                // flush输出流的缓冲
                osw.flush();
            }
            result = dealResponseResult(con.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    //使用HttpURLConnection发送get请求
    public static String sendGet(String urlParam, Map<String, String> paramsMap, String charset) {
        // 构建请求参数
        String params = setParams(paramsMap);
        HttpURLConnection con = null;
        String result = null;
        URL url = null;
        try{
            if (params != null && params.length() > 0) {
                url = new URL(urlParam + "?" + params);
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            result = dealResponseResult(con.getInputStream());
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //使用HttpURLConnection发送get请求,用utf-8编码请求
    public static String sendGet(String urlParam, Map<String, String> params)  {
        return PostUrlUtil.sendGet(urlParam, params, "utf-8");
    }

    //设置参数
    private static String setParams(Map<String, String> params){
        if (params == null || params.isEmpty()){
            return null;
        }
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> e : params.entrySet()) {
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
        }
        return sbParams.substring(0, sbParams.length() - 1).toString();
    }

    //设置参数
    private static String dealResponseResult(InputStream inputStream) throws IOException {
        String resultData = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (byteArrayOutputStream != null){
                byteArrayOutputStream.close();
            }
        }
        resultData = new String(byteArrayOutputStream.toByteArray(),"utf8");
        return resultData;
    }
}
