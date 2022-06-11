package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Mtest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/Beans.xml");
		
		MessageBean bean = (MessageBean)factory.getBean("korea");
		bean.sayHello("½ºÇÁ¸µ");
		
		bean = (MessageBean)factory.getBean("english");
		bean.sayHello("hello");
	}
}
