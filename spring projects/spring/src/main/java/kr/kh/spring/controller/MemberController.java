package kr.kh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/signup", method=RequestMethod.GET)
	public String signup() {
		
		return "member/signup";
	}
	
	@RequestMapping(value="/member/signup", method=RequestMethod.POST)
	public String signupPost(MemberVO member, Model model) {
		String msg = "회원 가입에 실패했습니다.";
		String url = "/member/signup";
		
		if(memberService.signup(member)) {
			msg = "회원 가입에 성공했습니다.";
			url = "/";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "message";
	}
	@GetMapping(value="/member/login")
	public String memberLogin() {
		return "member/login";
	}
	@PostMapping(value="/member/login")
	public String memberLoginPost(MemberVO member, Model model) {
		String msg = "로그인에 실패했습니다.";
		String url = "/member/login";
		MemberVO user = memberService.login(member); 
		if(user != null) {
			msg = "로그인에 성공했습니다.";
			url = "/";
		}
		model.addAttribute("user", user);
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return "message";
	}
	@GetMapping("/member/logout")
	public String memberLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		String msg = null;
		String url = "/";
		if(user != null) {
			session.removeAttribute("user");
			msg = "로그아웃에 성공했습니다.";
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return "message";
	}
	
}





