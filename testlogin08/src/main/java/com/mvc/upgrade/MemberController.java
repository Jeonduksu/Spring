package com.mvc.upgrade;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.dto.MemberDto;
import com.mvc.upgrade.model.service.MemberService;

@Controller
public class MemberController {
		
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		
		return "mvclogin";
	}
	
	@RequestMapping(value="/ajaxlogin.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session,@RequestBody MemberDto dto){
		logger.info("LOGIN");
		
		MemberDto res = memberservice.login(dto);
		
		System.out.println(dto.getMemberid());
		System.out.println(dto.getMemberpw());
		
		//체크는 false
		boolean check = false;
		if(res != null) {
			session.setAttribute("login",res);
			check = true;
		}
		
		System.out.println("check: " + check);
		
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		map.put("check",check);
		
		return map;
	}
}
