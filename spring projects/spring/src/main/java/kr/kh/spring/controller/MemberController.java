package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		
		return "member/signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signupPost(MemberVO member, Model model) {
		String msg = "회원 가입에 실패했습니다.";
		String url = "/signup";
		
		if(memberService.signup(member)) {
			msg = "회원 가입에 성공했습니다.";
			url = "/";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "message";
	}
}
