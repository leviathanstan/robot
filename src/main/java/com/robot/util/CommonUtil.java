package com.robot.util;

import com.robot.entity.RobotNews;

import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 * @author asce
 * @date 2018/9/20
 */
public class CommonUtil {

    /**
     * 格式化页码
     * @param pageNumStr
     * @return
     */
    public static int formatPageNum(String pageNumStr){
        int pageNum = 1;
        if (simpleMatch(Constant.RULE_NUMBER,pageNumStr))
            return Integer.parseInt(pageNumStr);
        return pageNum;
    }

    /**
     * 简单匹配
     * @param rule
     * @param content
     * @return
     */
    public static boolean simpleMatch(String rule, String content){
        if (content==null||content.trim().length()==0)
            return false;
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }

    /**
     *  文字预览
     * @author asce
     * @date 2018/10/18
     * @param
     * @return
     */
    public static String getPreview(String content){
        return content==null?null:content.replaceAll(Constant.RULE_PREVIEW,"");
    }

    /**
     * 将相对路径替换为绝对路径
     * @param content
     * @return
     */
    public static String getAbsolutePath(String content){
        content = content.replaceAll("src=\"/static","src=\""+Constant.HOST_ADDRESS+"/resources/robot");
        content = content.replaceAll("href=\"/static","href=\""+Constant.HOST_ADDRESS+"/resources/robot");
        return content;
    }

    /**
     * 将datetime转为date格式
     * @param oldDate
     * @return
     */
    public static String getDate(String oldDate){
        if(oldDate != null){
            try {
                LocalDateTime time = LocalDateTime.parse(oldDate,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
                return time.toLocalDate().toString();
            }catch (DateTimeParseException e){
                e.printStackTrace();
                return oldDate;
            }
        }else{
            return null;
        }
    }

    /**
     * 从正文内容中获取第一张图片路径
     * @param content
     * @return
     */
    public static String getFirstImgFromContent(String content){
        String regex = "src=\"static/img/(.*?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find())
            return Constant.HOST_ADDRESS+"/resources/robot/img/"+matcher.group(1);
        return null;
    }

    /**
     * 从正文内容中获取第一张图片路径（static前带斜杠）
     * @param content
     * @return
     */
    public static String getFirstImgFromContent2(String content){
        String regex = "src=\"/static/img/(.*?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find())
            return Constant.HOST_ADDRESS+"/static/robot/img/"+matcher.group(1);
        return null;
    }

    /**
     * 从正文内容中获取第一张图片路径（不含static）
     * @param content
     * @return
     */
    public static String getFirstImgFromContent3(String content){
        String regex = "src=\"/img/(.*?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find())
            return Constant.HOST_ADDRESS+"/static/robot/img/"+matcher.group(1);
        return null;
    }
    /**
     * 获取本机ip地址（补全http://)
     * @author asce
     * @date 2018/10/26
     * @param
     * @return
     */
    public static String getLocalIp() {
        // 获取操作系统类型
        String sysType = System.getProperties().getProperty("os.name");
        String ip;
        if (sysType.toLowerCase().startsWith("win")) {  // 如果是Windows系统，获取本地IP地址
            return "http://122.13.4.239";
//            String localIP = null;
//            try {
//                localIP = InetAddress.getLocalHost().getHostAddress();
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//            if (localIP != null) {
//                return "http://"+localIP;
//            }
        } else {
            ip = "http://120.79.30.14:8080"; // Linux
            if (ip != null) {
                return ip;
            }
        }
        return "127.0.0.1";
    }

    /**
     * 判断封面图片数量是否符合要求，不符合则从列表删除原有封面图片的对象
     * @param news
     * @param least
     * @return
     */
    public static boolean judgeCover(ArrayList<RobotNews> news,int least){
        int count = 0;
        for (RobotNews robotNews:news){
            if (robotNews.getImg()!=null&&!robotNews.getImg().equals("")){
                if(++count>=3)  break;
            }
        }
        if (count < least){
            //主要是防止重复，有可能超出要求的数量，让前端自行处理
            news.removeIf(discuss -> discuss.getImg()!=null);
            return true;
        }
        return false;
    }
}
