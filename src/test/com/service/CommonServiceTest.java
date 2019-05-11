package com.service;

import com.robot.entity.*;
import com.robot.scrapy.SpiderManager;
import com.robot.util.CommonUtil;
import com.robot.util.FileUtil;
import com.robot.util.GsonUtil;
import com.robot.util.Md5Util;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.util.IOUtils;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author asce
 * @date 2018/11/11
 */
public class CommonServiceTest {


    @Test
    public void test() throws IOException {
        File file = new File("C:\\Users\\10620\\Desktop\\供电局\\用户权限20181024.zip");

        FileInputStream input = new FileInputStream(file);

        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
    }
}
