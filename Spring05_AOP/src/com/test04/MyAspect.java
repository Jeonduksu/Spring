package com.test04;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	//오류안날시
	//Before -- 타겟 - AfterReturning - After
	//오류날시
	//Before -- 타겟(타겟이 실행이 나는데 에러가나서 바로 다음단계로)-- AfterThrowing -- After
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("zoom에 접속해서 qr을 찍는다.");
	}
	
	@After("execution(public * * (..))")
	public void after(JoinPoint join) {
		System.out.println("zoom을 종료합니다.");
	}
	
	@AfterReturning(pointcut="execution(public * * (..))",returning="returnVal")
	public void returning(JoinPoint join,Object returnVal) {
		System.out.println(returnVal + "공부하는 날이었다.");
	}
	
	@AfterThrowing("execution(public * com.test04.*.*(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날이었다.");
	}
}
