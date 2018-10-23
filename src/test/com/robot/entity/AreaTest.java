package com.robot.entity;

import com.robot.dao.AssociationDao;
import com.robot.dao.CompanyDao;
import com.robot.dao.InformationDao;
import com.robot.service.AssociationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class AreaTest {

    @Autowired
    CompanyDao companyDao;
    @Autowired
    InformationDao informationDao;

    @Autowired
    AssociationService associationService;

    @Test
    public void tesst() {
        // 获取当前日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 将当前日期时间减去两天
        LocalDateTime dateTime2 = now.minusDays(2);
        System.out.println(dateTime2);

        // 将当前日期时间加上五天
        LocalDateTime dateTime3 = now.plusDays(5);
        System.out.println(dateTime3);

        // 输出当前日期时间的年份
        System.out.println(now.getYear());

        System.out.println(now.getDayOfYear());

        System.out.println(now.getMonth());

        // 构造一个指定日期时间的对象
        LocalDateTime dateTime = LocalDateTime.of(2016, 10, 23, 8, 20);
        System.out.println(dateTime);
    }
    
}