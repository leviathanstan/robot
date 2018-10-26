package com.robot.util;

import java.net.*;
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
        content = content.replaceAll("src=\"static","stc=\"http://"+Constant.HOST_ADDRESS+":8080/static/robot");
        content = content.replaceAll("href=\"static","href=\"http://"+Constant.HOST_ADDRESS+":8080/static/robot");
        return content;
    }

    /**
     * 将datetime转为date格式
     * @param oldDate
     * @return
     */
    public static String getDate(String oldDate){
        if(oldDate != null && oldDate.contains("")){
            return oldDate.substring(0, oldDate.lastIndexOf(" "));
        }else{
            return oldDate;
        }

    }
}
