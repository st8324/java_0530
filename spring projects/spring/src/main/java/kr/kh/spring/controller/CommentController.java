package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
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
	@PostMapping("/comment/list/{bo_num}")
	public Map<String, Object> list(@RequestBody Criteria cri, @PathVariable("bo_num")int bo_num){
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommentVO> list = commentService.getCommentList(cri, bo_num);
		int totalCount = commentService.getTotalCount(bo_num);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		map.put("list", list);
		map.put("pm", pm);
		return map;
	}
	@PostMapping("/comment/delete")
	public Map<String, Object> delete(@RequestBody CommentVO comment){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = commentService.deleteComment(comment);
		map.put("res", res);
		return map;
	}
	@PostMapping("/comment/update")
	public Map<String, Object> update(@RequestBody CommentVO comment){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = commentService.updateComment(comment);
		map.put("res", res);
		return map;
	}
}
