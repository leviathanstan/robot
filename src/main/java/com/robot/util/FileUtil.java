package com.robot.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUtil {

    //检验图片文件后缀是否合法
    public static boolean validatePicture(String fileName) {   // .jpg/jpeg  .tiff  .gif  .png  .bmp  .raw  .svg
        if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg")
                || fileName.endsWith(".gif") || fileName.endsWith(".tiff") || fileName.endsWith(".raw")
                || fileName.endsWith(".bmp") || fileName.endsWith(".svg")) {
            return true;
        }
        return false;
    }

    //检验文档文件后缀是否合法
    public static boolean validateDoc(String fileName) {   //
        if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg")
                || fileName.endsWith(".gif") || fileName.endsWith(".tiff") || fileName.endsWith(".raw")
                || fileName.endsWith(".bmp") || fileName.endsWith(".svg")) {
            return true;
        }
        return false;
    }

    /**
     * 获得随机名字
     *
     * @return
     */
    public static String getFileHash(String fileName) {
        String prefix = fileName.substring(0, fileName.lastIndexOf("."));
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String dateSalt = (String.valueOf(CommonUtil.convertToString(new Date(), "yyyy-MM-dd"))).replaceAll("-", "");
        int salt = (int) (Math.random() * 1000);//加盐，防止文件重名
        String name = prefix + "" + salt + dateSalt;
        return Md5Util.encryptMd5(name) + "." + suffix;
    }

    /**
     * 上传压缩包
     * @param name
     * @param file
     */
    public static void zipUpload(String name, MultipartFile file, String FileUrl){
        try {
            file.transferTo(new File(FileUrl + name));
            System.out.println(FileUrl + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
