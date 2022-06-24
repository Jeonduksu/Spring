package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dao.TestDao;
import com.test.dto.TestDto;

@SpringBootApplication
@Controller
public class TestController {
	
	@Autowired
	private TestDto dto;
	
	public static void main(String[] args) {
		SpringApplication.run(TestController.class, args);
	}
	
	@RequestMapping("/test")
	public void test(HttpServletRequest request,TestDto dto) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
				
		System.out.println("이름은:" + name);
		System.out.println("나이:" + age);
		System.out.println("주소: " + addr);

	}
	
	@PostMapping("/output")
	public String output() {
		return "output";
	}
}
