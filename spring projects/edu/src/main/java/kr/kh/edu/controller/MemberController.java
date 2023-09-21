package kr.kh.edu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.edu.service.MemberService;
import kr.kh.edu.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member/signup")
	public String signup(Model model) {
		
		model.addAttribute("title", "회원가입");
		return "/member/signup";
	}
	
	@PostMapping("/member/signup")
	public String signupPost(MemberVO member,Model model) {
		
		//서비스에게 회원가입 시켜야 함 => 회원정보를 주면서 => 가입여부를 알려달라고 함
		boolean res = memberService.signup(member);
		if(res) {
			model.addAttribute("msg", "회원가입 성공!");
			model.addAttribute("url", "");
		}else {
			model.addAttribute("msg", "회원가입 실패!");
			model.addAttribute("url", "member/signup");
		}
		return "/main/message";
	}
	
	@ResponseBody
	@PostMapping("/member/id/check")
	public boolean idCheck(@RequestParam("id") String id){
		return memberService.checkId(id);
	}
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	@PostMapping("/member/login")
	public String loginPost(Model model, MemberVO member) {
		//입력받은 회원정보와 일치하는 회원 정보가 있으면 가져오라고 요청
		MemberVO user = memberService.login(member);
		//가져왔으면 => 로그인 성공하면 
		if(user != null) {
			model.addAttribute("user", user);
			model.addAttribute("msg", "로그인 성공!");
			model.addAttribute("url", "");
			//화면에서 보낸 자동 로그인 체크 여부를 user에 적용
			user.setAutoLogin(member.isAutoLogin());
		}else {
			model.addAttribute("msg", "로그인 실패!");
			model.addAttribute("url", "member/login");
		}
		return "/main/message";
	}
	@GetMapping("/member/logout")
	public String logout(Model model, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		session.removeAttribute("user");
		
		if(user != null) {
			user.setMe_session_limit(null);
			memberService.updateMemberSession(user);
		}
		
		model.addAttribute("msg", "로그아웃!");
		model.addAttribute("url", "");
		return "/main/message";
	}
}
