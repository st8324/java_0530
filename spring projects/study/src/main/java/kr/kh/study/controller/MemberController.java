package kr.kh.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/signup")
	public String memberSignup() {
		return "member/signup";
	}
	
	@PostMapping("/member/signup") //@RequestMapping(value="/member/signup", method=RequestMethod.POST)
	public String memberSignupPost(Model model, MemberVO member) {
		String msg , url;
		
		if(memberService.signup(member)) {
			msg = "회원가입 성공!";
			url = "/";
		}else {
			msg = "회원가입 실패!";
			url = "/member/signup"; 
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return "util/message";
	}
	@GetMapping("/member/login")
	public String memberLogin() {
		return "/member/login";
	}
}






