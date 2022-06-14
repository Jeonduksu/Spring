package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		Woman w = factory.getBean("woman",Woman.class);
		Man m = factory.getBean("man",Man.class);
		
		System.out.println("이건희 입장");
		w.classWork();
		System.out.println("이영희 입장");
		m.classWork();
	}

}
