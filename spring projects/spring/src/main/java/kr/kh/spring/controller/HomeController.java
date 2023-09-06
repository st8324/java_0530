package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.vo.MemberVO;

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
	@ResponseBody
	@PostMapping("/ajax/test")
	public Map<String, Object> ajaxTest(@RequestBody MemberVO member){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(member);
		map.put("name", "홍길동");
		return map;
	}
}







