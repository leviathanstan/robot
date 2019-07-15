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
    public static final int MEMBER_PAGE_COUTN = 12;         //会员列表的显示条数

    //正则规则
    public static String RULE_PHONE = "^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8}$";
    public static String RULE_EMAIL= "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static String RULE_NUMBER  = "^[0-9]*$";
    public static String RULE_PREVIEW = "(<(.*?)>)";

    public static String USER_NAME_REGULAR_EXPRESSION = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
    public static String PHONE_REGULAR_EXPRESSION = "^[0-9]{11}$";
    public static String FAX = "^(\\d{3,4}-)?\\d{7,8}$";
    public static String QQ = "^[1-9][0-9]{4,10}$";
    public static String POSTAL_CODE = "^[\\d]{6}$";
    public static String USER_WECHAT_REGULAR_EXPRESSION = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,10}$";
    public static String USER_COMPANY_NAME_REGULAR_EXPRESSION = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
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
    public static final String IMG_PATH =  "C:\\data\\resources\\img" + File.separator;
    //图片访问地址
    public static final String IMG_ACCESS_PATH = HOST_ADDRESS + "/resources/img/";
    //文件存放地址
    public static final String FILE_PATH =  "C:\\data\\resources\\file" + File.separator;
    //文件访问地址
    public static final String FILE_ACCESS_PATH = HOST_ADDRESS + "/resources/img/";
    //会员认证存放地址
    public static final String MEMBER_AUTHENTICATIONDATA_PATH = "C:\\data\\member\\authenticationData" + File.separator;
    //会员认证访问地址
    public static final String MEMBER_AUTHENTICATIONDATA_ACCESS_PATH = HOST_ADDRESS + "/member/authenticationData/";
    //联络人资料认证存放地址
    public static final String MEMBER_CONTACTINFODATAS_PATH = "C:\\data\\member\\contactInfoDatas" + File.separator;
    //联络人资料认证访问地址
    public static final String MEMBER_CONTACTINFODATAS_ACCESS_PATH = HOST_ADDRESS + "/member/contactInfoDatas/";
}
