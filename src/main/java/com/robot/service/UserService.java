package com.robot.service;

import com.robot.dao.UserDao;
import com.robot.entity.User;
import com.robot.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JavaMailSender mailSender;
    /**
     * 定时清除session,可考虑数据库或redis实现
     */
    ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
    /**
     * @param user
     * @return
     * @function用户登录
     */
    public String login(User user, HttpSession session) {
        User dbUser = null;
        user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
        if ((dbUser=userDao.login(user)) == null) {
            return GsonUtil.getErrorJson();
        }else{
            session.setAttribute("user",dbUser);
            return GsonUtil.getSuccessJson(dbUser);
        }
    }
    /**
     * @param user
     * @param confirmPassword
     * @return
     * @function 用户注册
     */
    public String register(User user, String confirmPassword, final HttpSession session) {
        if (ValidateUtil.isInvalidString(user.getUsername()) || ValidateUtil.isInvalidString(user.getPassword()) || ValidateUtil.isInvalidString(user.getEmail())) {
            return GsonUtil.getErrorJson("输入不能为空");
        }
        if (!(user.getPassword()).equals(confirmPassword)) {
            return GsonUtil.getErrorJson("两次输入密码不一致");
        }
        if (!ValidateUtil.isMatchEmail(user.getEmail())) {
            return GsonUtil.getErrorJson("邮箱格式不正确");
        }
        if (userDao.checkUsername(user) != null) {
            return GsonUtil.getErrorJson("用户名已存在");
        }
        if (userDao.checkEmail(user) != null) {
            return GsonUtil.getErrorJson("邮箱已经注册过");
        } else {
            session.setAttribute("registerUser",user);
            String code = CharacterUtil.getRandomString(5);
            try {
                SendEmailUtil.sendEmail(mailSender,user.getEmail(), code);
            }catch (Exception e){
                e.printStackTrace();
                return GsonUtil.getErrorJson("邮件发送失败！");
            }
            session.setAttribute("emailCode",code);
            exec.schedule(()->{
                if(session.getAttribute("emailCode")!=null)
                    session.removeAttribute("emailCode");
                }, 1000*60*5,TimeUnit.MILLISECONDS);
            return GsonUtil.getSuccessJson("已经发送验证码到你的邮箱,请验证");
        }
    }

    /**
     * @param checkCode
     * @param
     * @return
     * @function 注册时邮箱验证码验证
     */
    @Transactional
    public String validate(String checkCode,HttpSession session) {
        String code=(String) session.getAttribute("emailCode");
        User user = (User) session.getAttribute("registerUser");
        if(ValidateUtil.isInvalidString(checkCode)) {
            return GsonUtil.getErrorJson("输入不能为空");
        }else {
            if (!code.equals(checkCode)) {
                return GsonUtil.getErrorJson("验证码错误");
            } else{
                user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
                if (userDao.register(user)==1) {
                    //两个去除session方案：成功则去除session，不成功过期了也去除
                    session.removeAttribute("emailCode");
                    session.removeAttribute("registerUser");
                    return GsonUtil.getSuccessJson();
                }
            }
        }
        return GsonUtil.getErrorJson();
    }

    /**
     * 忘记密码
     *
     * @param email
     * @return
     */
    public String forgetPassword(String email,final HttpSession session){
        if(userDao.findEmail(email)==null){
            return GsonUtil.getErrorJson("该邮箱未注册");
        }else{
            String code = CharacterUtil.getRandomString(5);
            try {
                SendEmailUtil.sendEmail(mailSender,email, code);
            }catch (Exception e){
                e.printStackTrace();
                return GsonUtil.getErrorJson("邮件发送失败！");
            }
            session.setAttribute("emailCode",code);
            session.setAttribute("email",email);
            exec.schedule(()->{
                if(session.getAttribute("emailCode")!=null)
                    session.removeAttribute("emailCode");
                if(session.getAttribute("email")!=null)
                    session.removeAttribute("email");
            }, 1000*60*5,TimeUnit.MILLISECONDS);
            return GsonUtil.getSuccessJson("已发送验证码到你的邮箱，请验证");
        }
    }

    /**
     * 忘记密码时邮箱验证
     * @param checkCode
     * @return
     */
    public String validateEmail(String checkCode,HttpSession session){
        String code = (String) session.getAttribute("emailCode");
        if(ValidateUtil.isInvalidString(checkCode)) {
            return GsonUtil.getErrorJson("输入不能为空");
        }else {
            if (!code.equals(checkCode)) {
                return GsonUtil.getErrorJson("验证码错误");
            } else{
                session.removeAttribute("emailCode");
                return GsonUtil.getSuccessJson();
            }
        }
    }

    /**
     * 重置密码
     *
     * @param password
     * @param
     * @return
     */
    public String resetPassword(String password, String confirmPassword, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (!password.equals(confirmPassword)) {
            return GsonUtil.getErrorJson("两次输入密码不一致");
        }
        else {
            if(userDao.resetPassword(Md5Util.GetMD5Code(password), email) > 0) {
                session.removeAttribute("email");
                return GsonUtil.getSuccessJson();
            }
        }
        return GsonUtil.getErrorJson();
    }

}
