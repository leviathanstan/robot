package com.robot.filter;

import com.robot.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.robot.entity.User.*;

@SuppressWarnings("unused")
public class PermissionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();
        if (url.indexOf("admin") != -1) {
            HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
                    (HttpServletResponse) response);
            HttpSession session = httpRequest.getSession();
            Integer role = (Integer) session.getAttribute("role");
            switch (role) {
                case 1: {
                }
                break;
                case 2: {
                }
                break;
                default: {
                    httpRequest.getSession().invalidate();//session失效
                    request.getRequestDispatcher("/404.jsp").forward(request, response);
                }
            }
        }
        chain.doFilter(request, response);
        return;
    }

    private FilterConfig config = null;

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        this.config = arg0;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        this.config = null;
    }
}
