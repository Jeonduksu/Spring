package com.mvc.upgrade.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	
	public void before(JoinPoint join) {
		//대상 객체를 명시해야되서 join이 필요하다
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
	
		logger.info("-------Aop Start-------");
		
		Object[] args = join.getArgs();
		
		if(args != null) {
			logger.info("method: " + join.getSignature().getName());
			for(int i=0; i<args.length; i++) {
				logger.info(i+"번째: " + args[i]);
			}
		}
	}
	
	public void after(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
	
		logger.info("--------Aop end-------");
	}
	
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("--------Error Log-------");
		logger.info("ERROR : " + join.getArgs());
		logger.info("ERROR : " + join.toString());
	}
}
