package com.test01;

public class MessageBeanKo implements MessageBean{

	@Override
	public void sayHello(String name) {
		System.out.println("hello" + name);
	}

}
