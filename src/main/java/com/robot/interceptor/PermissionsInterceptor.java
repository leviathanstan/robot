package com.robot.interceptor;

import com.robot.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限过滤
 * @author asce
 * @date 2018/11/14
 */
public class PermissionsInterceptor extends HandlerInterceptorAdapter {

    private static String[] excludedUrlPrefix = {"/manager"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");

        String path = request.getServletPath();

        if (isExcludedUrlPrefix(path)) {
            return true;
        }

        User account = (User) request.getSession().getAttribute("account");

        if (account == null) {
            response.sendRedirect(request.getContextPath() + "/account/login");
            return false;
        }

        return super.preHandle(request, response, handler);
    }

    private boolean isExcludedUrlPrefix(String path) {
        for (String prefix: excludedUrlPrefix) {
            if (path.startsWith(prefix))
                return false;
        }
        return true;
    }

}
