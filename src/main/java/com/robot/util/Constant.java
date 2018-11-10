package com.robot.util;

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

    public static String USERNAMEREGULAREXPRESSION = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
    public static String PHONEREGULAREXPRESSION = "^[0-9]{11}$";
    public static String USERWECHATREGULAREXPRESSION = "^[a-zA-Z0-9\u4E00-\u9FA5]{3,10}$";
    public static String USERCOMPANYNAMEREGULAREXPRESSION = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
    public static String ADDRESSREGULAREXPRESSION = "^[a-zA-Z0-9\u4E00-\u9FA5]{0,20}$";
    public static String USERPOSITIONREGULAREXPRESSION = "^[a-zA-Z\\u4e00-\\u9fa5]+$";
    public static String EMAILREGULAREXPRESSION = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

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
    //public static final String IMG_PATH =  FILE_PATH + "img" + File.separator;
}
