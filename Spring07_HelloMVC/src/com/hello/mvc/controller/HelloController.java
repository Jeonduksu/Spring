package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService service;
	
	//command.equels랑 유사하다고 생각하면됨
	//이젠 spring에선 메소드로 나눈다
	@RequestMapping("/hello.do")
	//디스패처서블릿에서 받아온다
	public String getHello(Model model) {
		
		String value = service.getHello();
		
		model.addAttribute("message",value);
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/bye.do")
	//매개변수에 @RequestParam("name")String nickname 변수명이 다르면 이런식으로 해서 받아온다
	//변수명이 같으면 그냥 String만 써도된다.
	public ModelAndView getBye(String name) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message","Bye"+name);
		
		return mav;
	}
	
	
	
}
