package com.hello.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	//annotation을 붙여줬기때문에 자동생성
	@Autowired
	private HelloDao dao;
	
	public String getHello() {
		return "Hello,"+ dao.getHello();
	}
}
