package com.robot.util;

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
}
