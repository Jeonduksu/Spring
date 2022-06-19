package com.mvc.upgrade.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	//controller가 실행되기 전에 실행
	//true이면  controller가 실행
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	//Controller 호출 전 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		logger.info("[interceptor]:preHandle");
		
		//로그인 했는지 안했는지 체크
		if(request.getRequestURI().contains("/loginform.do")
			|| request.getRequestURI().contains("/ajaxlogin.do")
			|| request.getSession().getAttribute("login")!=null) {
			return true;
		}
		
		//로그인이 아닐경우 로그인폼으로 돌려보냄
		if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		
		return false;
	}
	
	//view담으로 forward 되기 전에 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						ModelAndView modelAndView) {
		
		logger.info("[interceptor]:postHandle");
	}
	
	//view까지 처리가 끝 난 후 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.info("[interceptor]:afterCompletion");
	}
}
