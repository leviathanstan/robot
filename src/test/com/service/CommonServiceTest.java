package com.service;

import com.robot.entity.Question;
import com.robot.entity.RobotNews;
import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import com.robot.util.Md5Util;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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

    @Test
    public void testParse(){
        String str = "2017-08-23 12:12:23.0";
        System.out.println(LocalDateTime.now());
        try {
            LocalDateTime time = LocalDateTime.parse(str,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
            System.out.println(time.toLocalDate());
        }catch (DateTimeParseException e){
            e.printStackTrace();
        }
    }

    public enum SeasonEnum {
        PRODUCT_NEWS(1), PRODUCT_RECOMMEND(2), PRODUCT_EVALUATE(3), BASIC_KNOWLEDGE(4), ENTERPRISE_NEWS(5), INDUSTRY_INFORMATION(6),
        POLICY_INFORMATION(7), MEMBER_NEWS(8), NOTICE(9), ASSOCIATION_NEWS(10), EXPERT_INTRODUCTION(11) ,COSULTING_FOCUS(12);
        private final int id;
        SeasonEnum(int id) {
            this.id = id;
        }
        public int getId(){
            return id;
        }
    }
    @Test
    public void testEnum(){
        System.out.println(SeasonEnum.PRODUCT_NEWS.getId());
    }

    @Test
    public void testJson(){
        String jsonstr = "{\n" +
                "\"surveyId\":1, \n" +
                "\"serialNumber\":1,\n" +
                "\"title\":\"first test\",\n" +
                "\"answerType\":0,\n" +
                "\"optionType\":0,\n" +
                "\"minNumber\":1,\n" +
                "\"maxNumber\":3,\n" +
                "\"precedentChoiceId\":0,\n" +
                "\"choices\":\n" +
                "[\n" +
                "{\n" +
                "\"serialNumber\":1,\n" +
                "\"title\":\"first choice\",\n" +
                "\"type\":0\n" +
                "},\n" +
                "{\n" +
                "\"serialNumber\":2,\n" +
                "\"title\":\"second choice\",\n" +
                "\"type\":0\n" +
                "},\n" +
                "{\n" +
                "\"serialNumber\":3,\n" +
                "\"title\":\"third choice\",\n" +
                "\"type\":0\n" +
                "},\n" +
                "{\n" +
                "\"serialNumber\":4,\n" +
                "\"title\":\"fouth choice\",\n" +
                "\"type\":1\n" +
                "}\n" +
                "]\n" +
                "}";
        Question question = GsonUtil.getObjectFromJson(jsonstr,Question.class);
        System.out.println(question);
    }

    @Test
    public void testStringEnd(){
        String time = "2018-09-26 11:33:00.0";
        String time2 = "2018-09-26 00:00:00.0";
        System.out.println(time.endsWith("00:00:00.0"));
        System.out.println(time2.endsWith("00:00:00.0"));
        System.out.println(time.substring(0,19));
    }
    @Test
    public void testBasic(){
        System.out.println(Md5Util.GetMD5Code("123456"));
    }
}
