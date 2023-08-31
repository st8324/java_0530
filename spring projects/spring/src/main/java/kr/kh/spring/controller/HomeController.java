package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home(Model model) {
		model.addAttribute("name", "abc");
		return "/main/home";
	}
	
	@RequestMapping(value="/test1")
	public String test1(Model model, String id, Integer age) {
		System.out.println("아이디 : " +id);
		System.out.println("나이 : " + age);
		return "test1";
	}
	
}
