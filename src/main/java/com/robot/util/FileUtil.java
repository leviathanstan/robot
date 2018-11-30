package com.robot.util;


public class FileUtil {

    //检验图片文件后缀是否合法
    public static boolean validatePicture(String fileName){   // .jpg/jpeg  .tiff  .gif  .png  .bmp  .raw  .svg
        if(fileName.endsWith(".jpg")||fileName.endsWith(".png")||fileName.endsWith(".jpeg")
                ||fileName.endsWith(".gif")||fileName.endsWith(".tiff")||fileName.endsWith(".raw")
                ||fileName.endsWith(".bmp")||fileName.endsWith(".svg")){
            return true;
        }
        return false;
    }

    //检验文档文件后缀是否合法
    public static boolean validateDoc(String fileName){   //
        if(fileName.endsWith(".jpg")||fileName.endsWith(".png")||fileName.endsWith(".jpeg")
                ||fileName.endsWith(".gif")||fileName.endsWith(".tiff")||fileName.endsWith(".raw")
                ||fileName.endsWith(".bmp")||fileName.endsWith(".svg")){
            return true;
        }
        return false;
    }
}
