package kr.kh.edu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.edu.vo.MemberVO;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model, String id) {
		System.out.println("id : " + id);
		return "/main/home";
	}
	@GetMapping("/{id}")
	public String id(@PathVariable("id") String id2) {
		System.out.println("id2 : " + id2);
		return "redirect:/";
	}
	@GetMapping("/ajax/test")
	public String ajaxTest() {
		
		return "/main/ajax";
	}
	@ResponseBody
	@PostMapping("/ajax/test1")//또는 @PostMapping("경로")
	public Map<String, Object> ajaxtTest1(@RequestBody MemberVO member){
		Map<String, Object> map = new HashMap();
		System.out.println("test1 : " + member);
		map.put("member", member);
		return map;
	}
	@ResponseBody
	@PostMapping("/ajax/test2")
	public Map<String, Object> ajaxtTest2(@RequestParam("me_id") String id, 
			@RequestParam("me_pw") String pw){
		Map<String, Object> map = new HashMap();
		System.out.println("test2 : " + id + "," + pw);
		MemberVO member = new MemberVO();
		member.setMe_id(id);
		member.setMe_pw(pw);
		map.put("member", member);
		return map;
	}
	@ResponseBody
	@PostMapping("/ajax/test3")
	public MemberVO ajaxtTest3(@RequestParam("me_id") String id, 
			@RequestParam("me_pw") String pw){
		System.out.println("test2 : " + id + "," + pw);
		MemberVO member = new MemberVO();
		member.setMe_id(id);
		member.setMe_pw(pw);
		return member;
	}
}
