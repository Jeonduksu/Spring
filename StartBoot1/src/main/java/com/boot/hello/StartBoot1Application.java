package com.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class StartBoot1Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot1Application.class, args);
	}
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
//	@GetMapping("/index")
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
