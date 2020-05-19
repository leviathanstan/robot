package com.robot.util;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
public class EmailUtil {

    public static void sendEmail(JavaMailSender javaMailSender, String email, String code) throws Exception{
        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom("robot_pubs001@126.com");//发件人
        message.setTo(email);//收件人
        message.setSubject("机器人网");//主题
        message.setText("您本次操作的验证码是：" + code);//正文
        javaMailSender.send(message);
    }
}
