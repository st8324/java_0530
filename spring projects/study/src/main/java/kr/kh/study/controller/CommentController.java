package kr.kh.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.pagination.PageMaker;
import kr.kh.study.service.CommentService;
import kr.kh.study.vo.CommentVO;
import kr.kh.study.vo.MemberVO;

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
		cri.setPerPageNum(3);
		List<CommentVO> list = commentService.getCommentList(bo_num, cri);
		int totalCount = commentService.getTotalCount(bo_num);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		map.put("list", list);
		map.put("pm", pm);
		return map;
	}
	@PostMapping("/comment/delete")
	public Map<String, Object> delete(@RequestBody CommentVO comment, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = commentService.deleteComment(comment, user);
		map.put("res", res);
		return map;
	}
	@PostMapping("/comment/update")
	public Map<String, Object> update(@RequestBody CommentVO comment, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = commentService.updateComment(comment, user);
		map.put("res", res);
		return map;
	}
}







