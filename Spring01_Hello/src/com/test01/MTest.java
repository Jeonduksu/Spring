package com.test01;

public class MTest {

	public static void main(String[] args) {
		//의존성 주입 내가 직접 대입한거
		MessageBean bean = new MessageBeanKo();
		bean.sayHello("스프링");
		
		bean = new MessageBeanEn();
		bean.sayHello("spring");
	}

}
