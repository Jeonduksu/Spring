package com.boot.jdbc.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.dto.MyDto;
import com.boot.jdbc.model.service.MyService;


//url 전체를 /myboard/list로 보낸다
//따른걸 보낸다 하면 ex) /myboard/register
@Controller
@RequestMapping("/myboard")
public class MyBoardController {
	
	@Autowired
	private MyService myService;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		model.addAttribute("list",myService.selectList());
		return "myboardlist";
	}
	
	@GetMapping("/detail")
	public  String selectOne(Model model,int myno) {
		
		model.addAttribute("dto",myService.selectOne(myno));
		return "myboarddetail";
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		return "myboardinsert";
	}
	
	@GetMapping("/insert")
	public String insert(MyDto dto) {
		
		int res = myService.insert(dto);
		
		if(res>0) {
			return "redirect:/myboard/list";
		}else {
			return "redirect:/myboard/insertform";
		}
	}
	
	
	@GetMapping("/updateform")
	public String updateform(Model model, int myno) {
		model.addAttribute("dto",myService.selectOne(myno));
		return "myboardupdate";
	}
	
	@GetMapping("/update")
	public String update(MyDto dto) {
		
		int res = myService.update(dto);
		
		if(res>0) {
			return "redirect:/myboard/list";
		}else {
			return "redirect:/myboard/updateform?myno="+dto.getMyno();
		}
		
		
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		
		int res = myService.delete(myno);
		
		if(res>0) {
			return "redirect:/myboard/list";
		}else {
			return "redirect:/myboard/detail?myno="+myno;
		}
	}
	/*
	 *    /datail: 상세보기
	 *    /insertform:글작성페이지이동
	 *    /insert:작성글 저장
	 *    /updateform: 글 수정 페이지 이동
	 *    /update:글 수정
	 *    /delete: 글 삭제
	 *    
	 *    
	 * 
	 */
}
