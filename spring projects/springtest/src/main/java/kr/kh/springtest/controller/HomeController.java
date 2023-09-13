package kr.kh.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.springtest.vo.MemberListVO;
import kr.kh.springtest.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("num", 1);		
		return "home";
	}
	@GetMapping("/member/login")
	public String memberLogin(String id, String pw) {
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		return "redirect:/";
	}
	@GetMapping("/member/login2")
	public String memberLogin2(MemberVO member) {
		System.out.println(member);
		return "redirect:/";
	}
	@GetMapping("/member/login3")
	public String memberLogin3(String []id, String []pw) {
		for(String tmp : id) {
			System.out.println("ID : " + tmp);
		}
		for(String tmp : pw) {
			System.out.println("PW : " + tmp);
		}
		return "redirect:/";
	}
	@GetMapping("/member/login4")
	public String memberLogin4(MemberListVO list) {
		System.out.println(list);
		return "redirect:/";
	}
}
