package com.test01;

public class MTest {
	public static void main(String[] args) {
		MessageBean bean = new MessageBeanKo();
		bean.sayHello("스프링");
		
		bean = new MessageBeanEn() ;
		bean.sayHello("잠와");
	}
}
