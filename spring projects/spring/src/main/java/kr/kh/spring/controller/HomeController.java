package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home(Model model) {
		//화면에 데이터를 전송하는 방법 model에 담아서 전송
		/*model.addAttribute("화면에서 사용할 이름", 전송할값);*/
		model.addAttribute("name", "abc");
		return "home";
	}
	
	@RequestMapping(value="/test1")
	public String test1(Model model, String id, Integer age) {
		System.out.println("아이디: " +id);
		System.out.println("나이 : " + age);
		return "test1";
	}
	
}
