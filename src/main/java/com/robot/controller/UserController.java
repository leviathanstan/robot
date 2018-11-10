package com.robot.controller;

import com.robot.entity.User;

import com.robot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author hua
 * @date 2018/11/2
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String login(User user, HttpSession session) {
        return userService.login(user, session);
    }

    /**
     * 用户注册
     *
     * @param user
     * @param confirmPassword
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String register(User user, @RequestParam(value = "confirmPassword") String confirmPassword, HttpSession session) {
        return userService.register(user, confirmPassword, session);
    }

    /**
     * 注册时邮箱验证
     *
     * @param checkcode
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "validate",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String validateRegister(@RequestParam(value = "checkcode") String checkcode,HttpSession session){
        return userService.validate(checkcode,session);
    }

    /**
     * 忘记密码
     *
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "forgetPassword", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String forgetPassword(String email, HttpSession session) {
        return userService.forgetPassword(email, session);
    }

    /**
     * 重置密码时邮箱验证
     *
     * @param checkcode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "validateEmail", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String validateEmail(@RequestParam String checkcode, HttpSession session) {
        return userService.validateEmail(checkcode, session);
    }

    /**
     * 重置密码
     *
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "resetPassword", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String resetPassword(String password, String confirmPassword, HttpSession session) {
        return userService.resetPassword(password, confirmPassword,session);
    }
}
