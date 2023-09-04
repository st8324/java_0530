package kr.kh.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		//서비스에게 게시글 리스트를 가져오라고 시킴 
		List<BoardVO> list = boardService.getBoardList();
		//가져온 리스트를 화면에 전송 
		model.addAttribute("list", list);
		return "/board/list";
	}
}




