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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String url = httpRequest.getRequestURI();
//		if(url.indexOf(".html") != -1){
//			HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
//					(HttpServletResponse) response);
//			try{
//				String redirectPath = config.getInitParameter("redirectPath");
//				String noFilterPath = config.getInitParameter("noFilterPath");
//				String[] noFilters = noFilterPath.split(";");
//
//				Integer rank = (Integer) httpRequest.getAttribute("rank");
//				if(0==rank){//游客访问页面鉴定
//
//				}else if(1==rank){//注册用户访问页面鉴定
//
//				}else if(2==rank){	//主办方
//
//				}else if(3==rank){//管理员访问页面鉴定
//
//				}else{
//					httpRequest.getSession().invalidate();//session失效
//					wrapper.sendRedirect(redirectPath);
//					return;
//				}
//			}catch(Exception ex){
//				//忽略异常
//				chain.doFilter(request, response);
//				return;
//			}
//		}else{
//			chain.doFilter(request, response);
//			return;
//		}
		if(url.indexOf("admin") != -1){
			HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
		(HttpServletResponse) response);
			HttpSession session = httpRequest.getSession();
			Integer rank = (Integer) session.getAttribute("rank");
			if (rank!=null&&rank==3){

			}else{
				httpRequest.getSession().invalidate();//session失效
				request.getRequestDispatcher("/404.jsp").forward(request,response);
				return;
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
