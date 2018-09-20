package com.robot.util;


public class PictureUtils {


    // 获得随机目录
    public static String generateRandomPath(String fileName) {
        int hashcode = fileName.hashCode();
        int d1 = hashcode & 0xf;
        int d2 = (hashcode >> 4) & 0xf;
        return "/" + d1 + "/" + d2;
    }


    //检验图片文件后缀是否合法
    public static boolean validatePicture(String fileName){   // .jpg/jpeg  .tiff  .gif  .png  .bmp  .raw  .svg
        if(fileName.endsWith(".jpg")||fileName.endsWith(".png")||fileName.endsWith(".jpeg")
                ||fileName.endsWith(".gif")||fileName.endsWith(".tiff")||fileName.endsWith(".raw")
                ||fileName.endsWith(".bmp")||fileName.endsWith(".svg")){
            return true;
        }
        return false;
    }


}
