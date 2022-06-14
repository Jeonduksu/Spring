package com.test02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Pointcut("execution(public * * (..))")
	public void myClass() {
		
	}
	
	@Before("myClass()")
	public void before() {
		System.out.println("zoom에 접속해서 qr을 찍는다.");
	}
	
	@After("myClass()")
	public void after() {
		System.out.println("zoom을 종료한다,");
	}
}
