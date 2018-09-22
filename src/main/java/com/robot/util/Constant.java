package com.robot.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 常量类
 * @author asce
 * @date 2018/9/20
 */
public class Constant {

    public static final int INFORMATION_PAGE_COUNT = 12;    //资讯每页显示条数

    //正则规则
    public static String RULE_PHONE = "^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8}$";
    public static String RULE_EMAIL= "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static String RULE_NUMBER  = "^[0-9]*$";

    //允许上传图片类型
    public final static List<String> TYPE_IMG = new ArrayList<String>(){{
        add("png");
        add("jpg");
        add("jpeg");
        add("bmp");
        add("gif");
        add("tiff");
    }};
    //项目根目录
    public static final String FILE_PATH =  new Object(){
        public  String getRootPath(){
            String path=this.getClass().getResource("/").getPath();
            path=path.replace("WEB-INF/classes/", "").substring(1);
            return path;
        }
    }.getRootPath();
    //图片存放地址
    //public static final String IMG_PATH =  FILE_PATH + "img" + File.separator;
}
