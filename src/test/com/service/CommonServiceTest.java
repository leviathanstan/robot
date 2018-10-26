package com.service;

import com.robot.entity.RobotNews;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.junit.Test;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author asce
 * @date 2018/10/18
 */
public class CommonServiceTest {

    @Test
    public void testPreview(){
        String str = "<div class=\"p8_content_view\"><div class=\"richContent  richContent3\">\n" +
                "<p><span style=\"font-size: 14px;\"> 2016年1月28日上午，广州市花都区经济开发区常务副主任林志斌携恒申智能化设备有限公司总经理黄元申来访广东省机器人协会办公室。</span></p>\n" +
                "\n" +
                "<p style=\"text-align: center;\"><img alt=\" \" src=\"static/img/news/ABUIABACGAAgioWstQUowKuI4gEwgAo4wAc!600x600.jpg\" style=\"width: 600px; height: 450px;\"></p>\n" +
                "\n" +
                "<p style=\"text-align: center;\">　　<span style=\"font-size: 14px;\">与会人员有广东省机器人协会会长苏汉明、协会执行会长任玉桐、协会副秘书长李桂凤、协会副秘书长谢晓立。</span></p>\n" +
                "\n" +
                "<p style=\"text-align: center;\"><img alt=\" \" src=\"static/img/news/ABUIABACGAAg3oWstQUo5JPP5wQwgAo4wAc!600x600.jpg\" style=\"width: 600px; height: 450px;\"></p>\n" +
                "\n" +
                "<p>　　<span style=\"font-size: 14px;\"> </span><span style=\"line-height: 21px; font-size: 14px;\">双方就花都区目前智能产业系统改造的需求进行了分析，并达成共识。希望借由协会这个平台为花都区传统产业转型升级打造一个更加宽广的窗口。</span></p>\n" +
                "\n" +
                "<p style=\"text-align: center;\"><img alt=\" \" src=\"static/img/news/ABUIABACGAAguYastQUosI6irQEwgAo4wAc!600x600.jpg\" style=\"width: 600px; height: 450px;\"></p>\n" +
                "\n" +
                "<p>　　<span style=\"font-size: 14px;\">苏会长表示，协会也一直在寻求更有建设性的发展道路，希望更好的为社会为社会服务，为企业服务。协会将更加深入企业，实现带动需求，帮企业做大做强的目标。任会长表示协会也将联合中科院利用3D打印的先进技术推动机器人部件创新研发，为花都区特色汽车产业实现达成更多汽车零部件需求与企业的对接。协会副秘书长李桂凤详细讲解了协会将要在2016年举办的活动——大讲坛的运宗旨和如何进行企业对接。会议结束后，双方共进午餐，活动圆满结束。</span></p>\n" +
                "</div>\n" +
                "\n" +
                "<div id=\"prevAndNextDiv\" style=\"width: 100%; margin-top: 30px; margin-left: 10px;\"> </div>\n" +
                "</div>";

        //notice.setIntroduction(notice.getIntroduction().replaceAll("src=\"/","src=\"/static/"));
        //System.out.println(str.replaceAll("(<img(.*?)>)",""));
        //System.out.println(str.replaceAll("src=\"/static","src=\"http://"+Constant.HOST_ADDRESS+"/static"));
        String regex = "src=\"static/img/(.*?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("http://120.79.30.14/static/robot/img/" + matcher.group(1));
        }
    }

    @Test
    public void testReplace(){

        String str = "<img src=\"static/img/notice/abc.jpg\"/>";
        System.out.println(str);
        System.out.println(str.replaceAll("src=\".","scr=\"/s"));
        Executor executor;
        ExecutorService executorService;
    }

//    @Test
//    public void replaceMember(){
//        ArrayList<Member> notices = associationDao.testMember();
//        for (Member notice: notices){
//            notice.setIntroduction(notice.getIntroduction().replaceAll("src=\"/","src=\"/static/"));
//            notice.setIntroduction(notice.getIntroduction().replaceAll("href=\"/","href=\"/static/"));
//        }
//        for(Member news:notices){
//            System.out.println(associationDao.updateMember(news));
//
//        }
//    }
    @Test
    public void testIP(){
        System.out.println(CommonUtil.getLocalIp());
    }

    @Test
    public void testFilter(){
        ArrayList<RobotNews> news = new ArrayList<>();
        for(int i=0;i<14;i++){
            news.add(new RobotNews());
        }
        news.get(3).setImg("abc");
        news.get(5).setImg("def");
        news.get(10).setImg("ggg");
        System.out.println(news.size());
        news.removeIf(news1 -> news1.getImg()!=null);
        System.out.println(news.size());
    }

}
