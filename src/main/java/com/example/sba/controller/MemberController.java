package com.example.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.sba.domain.Member;
import com.example.sba.mapper.MemberMapper;

@RestController
public class MemberController {
	
	@Autowired
	private MemberMapper mapper;

	@RequestMapping("/hello")
	public String hello() {
		return "RestController";
	}
	
	@RequestMapping("/helloJson")
	public String helloJson() {
		String msg = "Spring Boot는 REST 방식으로 JSON / XML 데이터를 전송합니다.";
		return msg;
	}
	
	@GetMapping("/jsonData/{email}/{pwd}")
	public ResponseEntity<Member> jsonData(@PathVariable String email,
			@PathVariable String pwd){
		System.out.println("여기는 되니?1");
		try {
			System.out.println("여기는 되니?2");
			Member member = mapper.getLoginMember(email, pwd);
			System.out.println("여기는 되니?3");
			return new ResponseEntity<>(member, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("list")
	public ModelAndView List() {
		System.out.println("여기는 되니?1");
		ModelAndView mav = null;
		System.out.println("여기는 되니?2");
		try {
			System.out.println("여기는 되니?3");
			mav = new ModelAndView("list.html");
			mav.addObject("member", mapper.getMemberList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
}




