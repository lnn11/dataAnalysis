package com.zhb.dataAnalysis.interceptor;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component("shiroInterceptor")
public class ShiroInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		System.out.println(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath());
//		System.out.println(request.getServletPath());
		Object obj = SecurityUtils.getSubject().getSession().getAttribute("token");
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0 && obj != null){
			for (Cookie cookie : cookies) {
				String value = cookie.getValue();
				if(obj.toString().indexOf(value) != -1){//登录验证通过
					if(request.getRequestURL().indexOf("login") != -1){
						response.sendRedirect(request.getContextPath()+"/home");
						return false;
					}
					return super.preHandle(request, response, handler);
				}
			}
			
			return doRequest(request, response, handler);
		}else{
			return doRequest(request, response, handler);
		}
	}

	private boolean doRequest(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception,IOException {
		if(request.getRequestURL().indexOf("login") != -1 || request.getRequestURL().indexOf("logout") != -1){
			return super.preHandle(request, response, handler);
		}else{
			System.out.println("request.getContextPath()==="+request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
	}
}
