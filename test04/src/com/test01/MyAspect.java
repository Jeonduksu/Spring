package com.test01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target = null;
		
		System.out.println("zoom에 접속해서 qr을 찍는다");
		
		try {
			target = invocation.proceed();

		} catch (Throwable e) {
			System.out.println("쉬는 날이었다");
		}finally {
			System.out.println("zoom을 종료한다.");
		}
		return target;
	}

}
