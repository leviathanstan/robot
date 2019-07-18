package com.robot.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@SuppressWarnings("unused")
public class PermissionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
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
                case 3:{
                }
                case 4:{
                }
                case 5:{
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
        this.config = arg0;
    }

    @Override
    public void destroy() {
        this.config = null;
    }
}
