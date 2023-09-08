package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.service.BoardService;
import kr.kh.spring.vo.BoardTypeVO;

@Controller
public class AdminController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/admin/board/type")
	public String boardType(Model model) {
		List<BoardTypeVO> list = boardService.getBoardTypeList();
		model.addAttribute("list", list);
		return "/admin/boardType";
	}
	
	@ResponseBody
	@PostMapping("/admin/board/type/insert")
	public Map<String, Object> boardTypeInsert(@RequestBody BoardTypeVO boardType){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = boardService.insertBoardType(boardType);
		map.put("res", res);
		return map;
	}
	@ResponseBody
	@PostMapping("/admin/board/type/delete")
	public Map<String, Object> boardTypeDelete(@RequestBody BoardTypeVO boardType){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = boardService.deleteBoardType(boardType);
		map.put("res", res);
		return map;
	}
	@ResponseBody
	@PostMapping("/admin/board/type/update")
	public Map<String, Object> boardTypeUpdate(@RequestBody BoardTypeVO boardType){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = boardService.updateBoardType(boardType);
		map.put("res", res);
		return map;
	}
}



