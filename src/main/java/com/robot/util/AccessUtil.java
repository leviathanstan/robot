package com.robot.util;

import org.aspectj.lang.JoinPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AccessUtil {

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 * 参考文章： http://developer.51cto.com/art/201111/305181.htm
	 * 
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
	 * 
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
	 * 192.168.1.100
	 * 
	 * 用户真实IP为： 192.168.1.110
	 * X-Forwarded-For：Squid 服务代理
       Proxy-Client-IP：apache 服务代理
       WL-Proxy-Client-IP：weblogic 服务代理
       HTTP_CLIENT_IP：有些代理服务器
       X-Real-IP：nginx服务代理
	 * @param request
	 * @return
	 */
	private static List<String> list = new ArrayList<String>();
	static{
		list.add("X-Forwarded-For");
		list.add("Proxy-Client-IP");
		list.add("WL-Proxy-Client-IP");
		list.add("HTTP_CLIENT_IP");
		list.add("HTTP_X_FORWARDED_FOR");
		list.add("X-Real-IP");
	}
	public static String getIpAddress(HttpServletRequest request) {
		if(request == null) return "";
		String ip = null;
		for(int i=0;i<list.size();i++){
			ip = request.getHeader(list.get(i));
			if(!CommonUtil.isNullOrEmpty(ip) && !"unknown".equalsIgnoreCase(ip)){
				return ip;
			}
		}
		if(CommonUtil.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	
	//获取访问地址，用户信息
	public static  String getAccessInfo(JoinPoint point){
			StringBuffer accessInfo = new StringBuffer();
			Object[] args = point.getArgs();
			HttpServletRequest servletRequest = null;
			HttpSession httpSession = null;
			for(int i=0;i<args.length;i++) {
	            if(args[i] instanceof HttpServletRequest){
					servletRequest =  (HttpServletRequest) args[i];
					httpSession = servletRequest.getSession();
					String phone = (String) httpSession.getAttribute("phone");
					accessInfo.append("[accessIP]=")
					.append(getIpAddress(servletRequest))
					.append(" ,[phone]=")
					.append(phone).append(" ,");
				}
			}
			 accessInfo.append("[request]=")
//			.append(point.getSignature().getDeclaringTypeName()).append(".")
//			.append(point.getSignature().getName())
//			.append(point.getStaticPart().toString())
			.append(point.getSignature().toString())
			.append(" ,[params]>>>>>");
			//.append(GsonUtil.getSuccessJson(point.getArgs()));
			 return accessInfo.toString();
		}
}
