package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping("/sample/all")
	public String sampleAll() {
		return "/sample/all";
	}
	
	@GetMapping("/sample/member")
	public String sampleMember() {
		return "/sample/member";
	}
	@GetMapping("/customLogin")
	public void customLogin(String error, String logout, Model model) {
		
	}
}
