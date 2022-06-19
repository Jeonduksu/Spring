package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter{
	//logger 객체 생성
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	//request, response 객체를 전달
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//http로 형변환
		HttpServletRequest req = (HttpServletRequest)request;
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		//스트링버퍼라서 tostirng으로 전환
		String url = req.getRequestURL().toString();
		String quertString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String agent = req.getHeader("User-Agent");
		
		
		logger.info("remoteaddr:" + remoteAddr);
		logger.info(uri);
		logger.info(url);
		logger.info(quertString);
		logger.info(referer);
		logger.info(agent);
		
		// 이렇게 연결 하는 방식이 체인 dofilter끼리 전달전달하는 체인 같다해서
		//dofilter -> dofilter ->servlet으로 보냄
		chain.doFilter(req,response);
	}

	@Override
	public void destroy() {
		
	}

}
