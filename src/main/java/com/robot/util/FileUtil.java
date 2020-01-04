package com.robot.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

public class FileUtil {

    //检验图片文件后缀是否合法
    public static boolean validatePicture(String fileName) {   // .jpg/jpeg  .tiff  .gif  .png  .bmp  .raw  .svg
        if (fileName == null)   return false;
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

    public static boolean validateZip(String fileName) {   //
        if (fileName.endsWith(".zip") || fileName.endsWith(".rar")) {
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
     *
     * @param name
     * @param file
     */
    public static void zipUpload(String name, MultipartFile file, String fileUrl) {
        try {
            file.transferTo(new File(fileUrl + name));
            System.out.println(fileUrl + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param src
     * @param dest
     * @return void
     * @function 复制文件
     * @author gdrcn
     * @date 2019/7/16
     */
    public static void copyFile(String src, String dest) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(src);
            File file = new File(dest);
            if (!file.exists())
                file.createNewFile();
            out = new FileOutputStream(file);
            int c;
            byte buffer[] = new byte[1024];
            while ((c = in.read(buffer)) != -1) {
                for (int i = 0; i < c; i++)
                    out.write(buffer[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param
     * @return boolean
     * @function 判断文件是否存在于文件夹下
     * @author gdrcn
     * @date 2019/7/16
     */
    public static boolean isExistFile(String fileName, String url) {
        File file = new File(url + fileName);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}
