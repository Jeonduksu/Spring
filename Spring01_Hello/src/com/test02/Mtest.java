package com.test02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Mtest {

	public static void main(String[] args) {
		//1.
//		Resource res = new FileSystemResource("src/com/test02/beans.xml");
		//2.
//		Resource res = new ClassPathResource("com/test02/beans.xml");
//		BeanFactory factory = new XmlBeanFactory(res);
		
		//의존성 주입 요즘에는 이렇게 작성
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/Beans.xml");
		
		//Object라서 형변환 해줘야된다
		MessageBean bean = (MessageBean)factory.getBean("korean");
		bean.sayHello("스프링");
		
		//english
		bean = (MessageBean)factory.getBean("english");
		bean.sayHello("Hello");
	}

}
