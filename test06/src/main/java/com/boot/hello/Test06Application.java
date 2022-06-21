package com.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class Test06Application {

	public static void main(String[] args) {
		SpringApplication.run(Test06Application.class, args);
	}
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}

}
