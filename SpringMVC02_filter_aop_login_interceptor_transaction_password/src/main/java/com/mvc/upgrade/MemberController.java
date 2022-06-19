package com.mvc.upgrade;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private MemberService service;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		
		return "mvclogin";
	}
	
	//요청방식이 같아야만 응답한다
	//post로왔으면 post로 와야한다
	//@RequestBody JSON데이터가 잘바껴서 갖고온다
	//@RequestBody 변환 ajax를 통해서 java객체로 바꾼다
	//@RequestBody : request객체로 넘어오는 데이터를 java 객체로
	//@ResponseBody : java객체를 response시에 바인딩
	@RequestMapping(value="/ajaxlogin.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session,@RequestBody MemberDto dto){
		logger.info("LOGIN");
		//MemberDto 객체라서 담는다
		MemberDto res = service.login(dto);
		
//		System.out.println(dto.getMemberid());
//		System.out.println(dto.getMemberpw());
		
		
		boolean check = false;
		//아이디체크
		if(res != null) {
			//비밀번호체크
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
			session.setAttribute("login",res);
			check = true;
			}
		}
		
//		System.out.println("check: " + check);
		
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		map.put("check",check);
		
		//서버로 리턴한다
		return map;
	}
	
	@RequestMapping("/registerform.do")
	public String memberInsertForm() {
		logger.info("REGISTER FORM");
		return "mvcregister";
	}
	
	@RequestMapping("/register.do")
	public String memberInsert(MemberDto dto) {
		//암호화
		 dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		System.out.println(dto.getMemberpw());
		
		int res =service.insert(dto);
		
		if(res>0) {
			return "redirect:loginform.do";
		}else {
			return "redirect:registform.do";
		}
	}
}
