package com.test09;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test09.TV;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test09/applicationContext.xml");
		System.out.println("spring bean container��ü ����");
		
		TV tv=(TV)factory.getBean("samsung");
		
		tv.powerOn();
		tv.volUp();
		tv.volDown();
		tv.powerOff();
	}

}
