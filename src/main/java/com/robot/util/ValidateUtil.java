package com.robot.util;

import java.util.regex.Pattern;

public class ValidateUtil {

    /**
     * 判断是否为空
     * @param str
     * @return true为空 false不为空
     */
    public static boolean isInvalidString(String str) {
        if (str == null || str.equals(""))
            return true;
        return false;

    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断是否符合邮件格式
     * @param str
     * @return true符合 false不符合
     */
    public static boolean isMatchEmail(String str) {
        if (Pattern.matches(Constant.RULE_EMAIL, str))
            return true;
        return false;
    }

    public static boolean isMatchDate(String str){
        if(Pattern.matches(Constant.DATE,str))
            return true;
        return false;
    }
}
