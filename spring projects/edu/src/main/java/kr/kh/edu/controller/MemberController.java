package kr.kh.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.edu.service.MemberService;
import kr.kh.edu.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/test")
	public String test() {
		MemberVO member = memberService.getMember("qwe123");
		System.out.println(member);
		return "redirect:/";
	}
}
