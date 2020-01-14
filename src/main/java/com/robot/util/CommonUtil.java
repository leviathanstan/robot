package com.robot.util;

import com.robot.dto.InformationDto;
import com.robot.entity.Detail;
import com.robot.entity.Robot;
import com.robot.entity.RobotNews;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 *
 * @author asce
 * @date 2018/9/20
 */
public class CommonUtil {

    public static void getTime(String flag) {
        Calendar c = Calendar.getInstance();
        String date = new SimpleDateFormat("HH:mm:ss.S").format(c.getTime());
        System.out.println(date + " " + flag);
    }

    public static void getTime(int flag) {
        Calendar c = Calendar.getInstance();
        String date = new SimpleDateFormat("HH:mm:ss.S").format(c.getTime());
        System.out.println(date + " " + flag);
    }


    public static String getUUID() {
        return String.valueOf(UUID.randomUUID()).replaceAll("-", "");
    }

    /**
     * 格式化页码
     *
     * @param pageNumStr
     * @return
     */
    public static int formatPageNum(String pageNumStr) {
        int pageNum = 1;
        if (simpleMatch(Constant.RULE_NUMBER, pageNumStr))
            return Integer.parseInt(pageNumStr);
        return pageNum;
    }

    /**
     * 是否为数字
     *
     * @param parm
     * @return
     */
    public static int formateParmNum(String parm) {
        if (!simpleMatch(Constant.RULE_NUMBER, parm)) {
            return 0;
        }
        return Integer.parseInt(parm);
    }

    /**
     * 是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.equals("")) ? true : false;
    }

    /**
     * 简单匹配
     *
     * @param rule
     * @param content
     * @return
     */
    public static boolean simpleMatch(String rule, String content) {
        if (content == null || content.trim().length() == 0)
            return false;
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }

    /**
     * 判断是否包含
     *
     * @param sentence
     * @param keywords
     * @return
     */
    public static boolean isContains(String sentence, String[] keywords) {
        int tag = 0;
        String[] sentences = sentence.split("、");
        for (String tinySentence : sentences) {
            for (String keyword : keywords) {
                if (keyword.equals(tinySentence) || keyword == tinySentence) {
                    tag++;
                    break;
                }
            }
        }
        if (tag != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 文字预览
     *
     * @param
     * @return
     * @author asce
     * @date 2018/10/18
     */
    public static ArrayList<Detail> getPreview(ArrayList<Detail> content) {
        if (content.size() == 0) return null;
        content.get(0).setContent(content.get(0).getContent().replaceAll(Constant.RULE_PREVIEW, ""));
        return content;
    }

    /**
     * 文字预览
     *
     * @param
     * @return
     * @author asce
     * @date 2018/10/18
     */
    public static String getPreview(String content) {
        return content == null ? null : content.replaceAll(Constant.RULE_PREVIEW, "");
    }

    /**
     * 将相对路径替换为绝对路径
     *
     * @param content
     * @return
     */
    public static ArrayList<Detail> getAbsolutePath(ArrayList<Detail> content) {
        for (Detail str : content) {
            str.setContent(str.getContent().replaceAll("src=\"/static", "src=\"" + Constant.HOST_ADDRESS + "/resources"));
            str.setContent(str.getContent().replaceAll("href=\"/static", "href=\"" + Constant.HOST_ADDRESS + "/resources"));
        }
        return content;
    }

    /**
     * 将相对路径替换为绝对路径
     *
     * @param content
     * @return
     */
    public static String getAbsolutePath(String content) {
        content = content.replaceAll("src=\"/static", "src=\"" + Constant.HOST_ADDRESS + "/resources");
        content = content.replaceAll("href=\"/static", "href=\"" + Constant.HOST_ADDRESS + "/resources");
        return content;
    }

    /**
     * 将datetime转为date格式
     *
     * @param oldDate
     * @return
     */
    public static String getDate(String oldDate) {
        if (oldDate != null) {
            try {
                LocalDateTime time = LocalDateTime.parse(oldDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
                return time.toLocalDate().toString();
            } catch (DateTimeParseException e) {
                e.printStackTrace();
                return oldDate;
            } catch (Exception e) {
                e.printStackTrace();
                return oldDate;
            }
        } else {
            return null;
        }
    }

    /**
     * 时间格式化（informationController）--首页
     *
     * @param informations
     */
    public static void formateDateTimeToDate(ArrayList<RobotNews> informations) {
        for (RobotNews information : informations) {
            information.setPostDate(getDate(information.getPostDate()));
        }
    }

    /**
     * 时间格式化（informationController）--首页
     *
     * @param informations
     */
    public static void formateDateTimeToDate(List<InformationDto> informations) {
        for (InformationDto information : informations) {
            information.setPostDate(getDate(information.getPostDate()));
        }
    }

    public static String formateDbTime(String dbTime) {
        if (dbTime == null) return null;
        if (dbTime.endsWith("00:00:00.0")) {
            LocalDateTime time = LocalDateTime.parse(dbTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
            return time.toLocalDate().toString();
        }
        return dbTime.substring(0, 16);
    }


    /**
     * 从正文内容中获取第一张图片路径
     *
     * @param content
     * @return
     */
    public static String getFirstImgFromContent(ArrayList<Detail> content) {
        if (content.size() != 0) {
            String regex = "src=\"/static/img/(.*?)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content.get(0).getContent());
            if (matcher.find())
                return Constant.HOST_ADDRESS + "/resources/img/" + matcher.group(1);
        }
        return null;
    }

    /**
     * 从正文内容中获取第一张图片路径
     *
     * @param content
     * @return
     */
    public static String getFirstImgFromContent(String content) {
        if (content != null) {
            String regex = "src=\"/static/img/(.*?)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            if (matcher.find())
                return Constant.HOST_ADDRESS + "/resources/img/" + matcher.group(1);
        }
        return null;
    }

    /**
     * 获取本机ip地址（补全http://)
     *
     * @param
     * @return
     * @author asce
     * @date 2018/10/26
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
     *
     * @param news
     * @param least
     * @return
     */
    public static boolean judgeCover(ArrayList<RobotNews> news, int least) {
        int count = 0;
        for (RobotNews robotNews : news) {
            if (robotNews.getImg() != null && !robotNews.getImg().equals("")) {
                if (++count >= 3) break;
            }
        }
        if (count < least) {
            //主要是防止重复，有可能超出要求的数量，让前端自行处理
            news.removeIf(discuss -> discuss.getImg() != null);
            return true;
        }
        return false;
    }

    /**
     * 上传图片
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/30
     */
    public static List<String> saveImg(MultipartFile[] files) {
        if (files == null || files.length == 0) {
            return null;
        }
        ArrayList<String> paths = new ArrayList<>();
        String path = null;
        for (MultipartFile file : files) {
            try {
                //获取文件名作为保存到服务器的文件名称
                if (!file.isEmpty() && file.getSize() > 0) {
                    String filename = file.getOriginalFilename();
                    if (!FileUtil.validatePicture(filename)) {
                        continue;
                    }
                    String type = filename.substring(filename.lastIndexOf(".") + 1);    //获取文件后缀名称
                    String imgName = CommonUtil.getUUID() + "." + type;
                    //每月新建一个文件夹存放
                    LocalDate data = LocalDate.now();
                    String mkdir = data.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                    File tempMkdir = new File(Constant.IMG_PATH + mkdir);
                    if (tempMkdir.exists()) {
                        if (!tempMkdir.isDirectory()) {
                            tempMkdir.mkdir();
                        }
                    } else {
                        tempMkdir.mkdir();
                    }
                    //保存
                    path = Constant.IMG_PATH + mkdir + File.separator + imgName;
                    File saveFile = new File(path);
                    file.transferTo(saveFile);
                    path = Constant.IMG_ACCESS_PATH + mkdir + "/" + imgName;
                    paths.add(path);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return paths;
    }

    /**
     * 上传文档
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/30
     */
    public static ArrayList<String> saveFile(MultipartFile[] files) throws Exception{
        if (files == null || files.length == 0) {
            return null;
        }
        ArrayList<String> paths = new ArrayList<>();
        String path = null;
        for (MultipartFile file : files) {
            try {
                //获取文件名作为保存到服务器的文件名称
                if (!file.isEmpty() && file.getSize() > 0) {
                    String filename = file.getOriginalFilename();
                    if (filename == null || !FileUtil.validateDoc(filename)) {
                        continue;
                    }
                    String type = filename.substring(filename.lastIndexOf(".") + 1);    //获取文件后缀名称
                    String fileName = CommonUtil.getUUID() + "." + type;
                    //每月新建一个文件夹存放
                    LocalDate data = LocalDate.now();
                    String mkdir = data.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                    File tempMkdir = new File(Constant.FILE_PATH + mkdir);
                    if (tempMkdir.exists()) {
                        if (!tempMkdir.isDirectory()) {
                            if (!tempMkdir.mkdir())  throw new RuntimeException("文件夹创建失败");
                        }
                    } else {
                        if (!tempMkdir.mkdir())  throw new RuntimeException("文件夹创建失败");
                    }
                    //保存
                    path = Constant.FILE_PATH + mkdir + File.separator + fileName;
                    File saveFile = new File(path);
                    file.transferTo(saveFile);
                    path = Constant.FILE_ACCESS_PATH + mkdir + "/" + fileName;
                    paths.add(path);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return paths;
    }

    public static ArrayList<String> saveZip(MultipartFile[] files) throws Exception{
        if (files == null || files.length == 0) {
            return null;
        }
        ArrayList<String> paths = new ArrayList<>();
        String path = null;
        for (MultipartFile file : files) {
            try {
                //获取文件名作为保存到服务器的文件名称
                if (!file.isEmpty() && file.getSize() > 0) {
                    String filename = file.getOriginalFilename();
                    if (filename == null || !FileUtil.validateZip(filename)) {
                        continue;
                    }
                    String type = filename.substring(filename.lastIndexOf(".") + 1);    //获取文件后缀名称
                    String fileName = CommonUtil.getUUID() + "." + type;
                    //每月新建一个文件夹存放
                    LocalDate data = LocalDate.now();
                    String mkdir = data.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                    File tempMkdir = new File(Constant.FILE_PATH + mkdir);
                    if (tempMkdir.exists()) {
                        if (!tempMkdir.isDirectory()) {
                            if (!tempMkdir.mkdir())  throw new RuntimeException("文件夹创建失败");
                        }
                    } else {
                        if (!tempMkdir.mkdir())  throw new RuntimeException("文件夹创建失败");
                    }
                    //保存
                    path = Constant.FILE_PATH + mkdir + File.separator + fileName;
                    File saveFile = new File(path);
                    file.transferTo(saveFile);
                    path = Constant.FILE_ACCESS_PATH + mkdir + "/" + fileName;
                    paths.add(path);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return paths;
    }

    /**
     * 上传会员信息
     * @param file
     * @return
     */
    public static String uploadMember(MultipartFile file, String fileType) {
        String fileName = file.getOriginalFilename();
        if (fileName == null)   return GsonUtil.getErrorJson();
        if (!fileName.endsWith(".zip")) {
            return GsonUtil.getErrorJson("格式不支持");
        } else {
            String fileNameByMD5 = FileUtil.getFileHash(fileName);
            FileUtil.zipUpload(fileNameByMD5, file, fileType);
            return fileNameByMD5;
        }
    }

    /**
     * Date转换为字符串
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */
    public static String convertToString(Date date, String pattern) {
        if (date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * @function 将类转为一个Map集合
     * @author gdrcn
     * @date 2019/7/16
     * @param obj
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return map;
    }
}
