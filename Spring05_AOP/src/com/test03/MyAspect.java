package com.test03;



import org.aspectj.lang.JoinPoint;


public class MyAspect {
	
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		System.out.println("zoom에 접속해서 qr을 찍는다.");
	}
	
	public void after(JoinPoint join) {
		System.out.println("zoom을 종료한다.");
	}
}
