package com.robot.util;

import java.io.File;

/**
 * 常量类
 * @author asce
 * @date 2018/9/20
 */
public class Constant {

    public static final int INFORMATION_PAGE_COUNT = 12;    //资讯每页显示条数
    public static final int PRODUCT_PAGE_COUNT = 12;        //产品查找每页显示条数

    //正则规则
    public static String RULE_PHONE = "^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8}$";
    public static String RULE_EMAIL= "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static String RULE_NUMBER  = "^[0-9]*$";
    public static String RULE_PREVIEW = "(<(.*?)>)";

    public static String USER_NAME_REGULAR_EXPRESSION = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
    public static String PHONE_REGULAR_EXPRESSION = "^[0-9]{11}$";
    public static String USER_WECHAT_REGULAR_EXPRESSION = "^[a-zA-Z0-9\u4E00-\u9FA5]{3,10}$";
    public static String USER_COMPANYNAME_REGULAR_EXPRESSION = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
    public static String ADDRESS_REGULAR_EXPRESSION = "^[a-zA-Z0-9\u4E00-\u9FA5]{0,20}$";
    public static String USER_POSITION_REGULAR_EXPRESSION = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
    public static String EMAIL_REGULAR_EXPRESSION = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    //允许上传图片类型
//    public final static List<String> TYPE_IMG = new ArrayList<String>(){{
//        add("png");
//        add("jpg");
//        add("jpeg");
//        add("bmp");
//        add("gif");
//        add("tiff");
//    }};
    //本机ip
    public static String HOST_ADDRESS = CommonUtil.getLocalIp();
//    //项目根目录
//    public static final String FILE_PATH =  new Object(){
//        public  String getRootPath(){
//            String path=this.getClass().getResource("/").getPath();
//            path=path.replace("WEB-INF/classes/", "").substring(1);
//            return path;
//        }
//    }.getRootPath();
//    //classes下目录
//    public static final String CLASSES_PATH = new Object(){
//        public  String getRootPath(){
//            String path=this.getClass().getResource("/").getPath();
//            return path;
//        }
//    }.getRootPath();

    //图片存放地址
    public static final String IMG_PATH =  "E:\\Apache\\Apache24\\htdocs\\face\\" + "img" + File.separator;
    //文件存放地址
    public static final String FILE_PATH =  "E:\\Apache\\Apache24\\htdocs\\face\\" + "file" + File.separator;

}
