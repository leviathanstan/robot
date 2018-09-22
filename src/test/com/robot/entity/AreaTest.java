package com.robot.entity;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class AreaTest {

    @Test
    public void test() {
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


    @Test
    public void test2() {
        LocalTime start = LocalTime.now();
        try {
            //让线程睡眠3s
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        LocalTime end = LocalTime.now();
        //获取end和start的时间间隔
        Duration duration = Duration.between(start, end);

        //可能会输出PT3S或者输出PT3.001S，至于多出来的0.001秒其实就是除去线程睡眠时间执行计算时间间隔那句代码消耗的时间
        System.out.println(duration);
    }
}