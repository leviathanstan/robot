package com.robot.service;

import com.google.gson.Gson;
import com.robot.dao.UserDao;
import com.robot.entity.User;
import com.robot.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * @param user
     * @return
     * @function用户登录
     */
    public String login(User user, HttpSession session) {

        user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
        if (userDao.login(user) == null) {
            return GsonUtil.getErrorJson();
        }else{
            user = userDao.login(user);
            session.setAttribute("user",user);
            return GsonUtil.getSuccessJson(user);
        }
    }
    /**
     * @param user
     * @param confirmPassword
     * @return
     * @function用户注册
     */
    public String registe(User user, String confirmPassword, HttpSession session) {
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
            session.setAttribute("user",user);

            String code = CharacterUtil.getRandomString(5);
            Map<String, String> map = new HashMap<>();
            map.put("result", "success");
            map.put("message", "已经发送验证码到你的邮箱,请验证");

            SendEmailUtil.sendEmail(mailSender,user.getEmail(), code);
            session.setAttribute("emailCode",code);
            return new Gson().toJson(map);
        }
    }

    /**
     * @param checkcode
     * @param user
     * @return
     * @function注册时邮箱验证码验证
     */
    @Transactional
    public String validate(String checkcode,String code,User user) {
        if(ValidateUtil.isInvalidString(checkcode)) {
            return GsonUtil.getErrorJson("输入不能为空");
        }else {
            if (!code.equals(checkcode)) {
                return GsonUtil.getErrorJson("验证码错误");
            } else{
                user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
                userDao.registe(user);
                return GsonUtil.getSuccessJson();
            }
        }
    }

    /**
     * 忘记密码
     *
     * @param email
     * @return
     */
    public String forgetPassword(String email,HttpSession session){

        if(userDao.findEmail(email)==null){
            return GsonUtil.getErrorJson("该邮箱未注册");
        }else{
            String code = CharacterUtil.getRandomString(5);

            SendEmailUtil.sendEmail(mailSender,email,code);
            session.setAttribute("emailCode",code);
            session.setAttribute("email",email);
            return GsonUtil.getSuccessJson("已发送验证码到你的邮箱，请验证");
        }
    }

    /**
     * 忘记密码时邮箱验证
     * @param checkcode
     * @return
     */
    public String validateEmail(String checkcode,String code){
        if(ValidateUtil.isInvalidString(checkcode)) {
            return GsonUtil.getErrorJson("输入不能为空");
        }else {
            if (! code.equals(checkcode)) {
                return GsonUtil.getErrorJson("验证码错误");
            } else{
                return GsonUtil.getSuccessJson();
            }
        }
    }

    /**
     * 重置密码
     *
     * @param password
     * @param email
     * @return
     */
    @Transactional
    public String resetPassword(String password, String email, String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            return GsonUtil.getErrorJson("两次输入密码不一致");
        }
        else {
            if(userDao.resetPassword(Md5Util.GetMD5Code(password), email) > 0)
                return GsonUtil.getSuccessJson();
        }
        return GsonUtil.getErrorJson();
    }

}
