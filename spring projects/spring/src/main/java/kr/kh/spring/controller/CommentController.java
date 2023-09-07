package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.service.CommentService;
import kr.kh.spring.vo.CommentVO;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@PostMapping("/comment/insert")
	public Map<String, Object> insert(@RequestBody CommentVO comment){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = commentService.insertComment(comment);
		map.put("res", res);
		return map;
	}
	@PostMapping("/comment/list")
	public Map<String, Object> list(@RequestBody Criteria cri){
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommentVO> list = commentService.getCommentList(cri);
		map.put("list", list);
		return map;
	}
	
}
