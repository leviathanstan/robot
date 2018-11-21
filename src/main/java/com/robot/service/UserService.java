package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.UserDao;
import com.robot.entity.User;
import com.robot.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.List;
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
     * 搜索用户
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    public String findUser(User user, String pageNumStr){
        int pageNum = CommonUtil.formatPageNum(pageNumStr);
        PageHelper.startPage(pageNum,Constant.PRODUCT_PAGE_COUNT);
        List<User> users = userDao.find(user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 管理员登录
     * @author asce
     * @date 2018/11/15
     * @param
     * @return
     */
    public String adminLogin(User user,HttpSession session){
        User dbUser = null;
        user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
        user.setRank(1);
        if((dbUser=userDao.login(user)) == null){
            return GsonUtil.getErrorJson("密码或账号错误");
        }else{
            session.setAttribute("user",dbUser);
            session.setAttribute("rank",1);
            return GsonUtil.getSuccessJson();
        }
    }

    /**
     * @param user
     * @return
     * @function用户登录
     */
    public String login(User user, HttpSession session) {
        User dbUser = null;
        user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
        if ((dbUser=userDao.login(user)) == null) {
            return GsonUtil.getErrorJson("密码或账号错误");
        }else{
            session.setAttribute("user",dbUser);
            return GsonUtil.getSuccessJson(dbUser);
        }
    }
    /**
     * @param user
     * @return
     * @function 用户注册信息判断
     */
    public String validate(User user, final HttpSession session) {
        if (ValidateUtil.isInvalidString(user.getUsername()) || ValidateUtil.isInvalidString(user.getPassword()) || ValidateUtil.isInvalidString(user.getEmail())) {
            return GsonUtil.getErrorJson("输入不能为空");
        }
        if (!ValidateUtil.isMatchEmail(user.getEmail())) {
            return GsonUtil.getErrorJson("邮箱格式不正确");
        }
        User user1 = new User();
        user1.setEmail(user.getEmail());
        if (userDao.find(user1).size()!=0) {
            return GsonUtil.getErrorJson("邮箱已经注册过");
        }
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

    /**
     * @param checkCode
     * @param
     * @return
     * @function 注册验证码验证
     */
    public String register(String checkCode,HttpSession session) {
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
                }else
                    return GsonUtil.getErrorJson();
            }
        }

    }

    /**
     * 忘记密码
     *
     * @param email
     * @return
     */
    public String forgetPassword(String email,final HttpSession session){
        User user = new User();
        user.setEmail(email);
        if(userDao.find(user).size()!=0){
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
     * @param password
     * @param
     * @return
     */
    public String resetPassword(String password, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if(userDao.resetPassword(Md5Util.GetMD5Code(password), email) > 0) {
            session.removeAttribute("email");
            return GsonUtil.getSuccessJson();
        }
        return GsonUtil.getErrorJson();
    }

}
