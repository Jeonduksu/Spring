package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		TV tv = factory.getBean("lgTV",TV.class);
		tv.powerOff();
		tv.volDown();
		
		tv = (TV)factory.getBean("ss");
		tv.powerOff();
		tv.volUp();
	}

}
