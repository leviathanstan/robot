package com.robot.interceptor;

import com.robot.annotation.Authority;
import com.robot.dao.UserDao;
import com.robot.entity.User;
import com.robot.enums.Permission;
import com.robot.enums.Role;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Ning on 2019/5/9
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserDao userDao;


    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User) request.getSession().getAttribute("user");

//        user = userDao.getAccount(2);

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Authority annotation = method.getAnnotation(Authority.class);

            //当含有注解@AuthorityType时
            if (annotation != null) {
                if (user == null) {
                    response.sendRedirect(request.getContextPath() + "/");
                    return false;
                }

                List<Permission> userPermission = user.getPermissions();
                Role userRole = user.getRole();

                Permission permission = annotation.permission();
                Role role = annotation.role();

                if (permission != null && !"".equals(permission)) {
                    if (userPermission == null || "".equals(userPermission)) {
                        response(response);
                        return false;
                    }
                    if (!userPermission.contains(permission)) {
                        response(response);
                        return false;
                    }
                }

                if(role != null && !"".equals(role)){
                    if(userRole == null || "".equals(userRole)){
                        response(response);
                        return false;
                    }
                    if(userRole == role || userRole.equals(role)){

                    }
                }
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    private void response(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(GsonUtil.getErrorJson("你没有该权限"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
