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
	@GetMapping("/board/detail")
	public String boardDetail(Model model, Integer bo_num) {
		//게시글 가져오기 전에 서비스에게 게시글 번호를 주면서 조회수를 1증가하라고 요청
		boardService.updateViews(bo_num);
		//서비스에게 게시글 번호를 주면서 게시글을 가져오라고 요청
		BoardVO board = boardService.getBoard(bo_num);
		//가져온 게시글을 화면에 전송
		model.addAttribute("board", board);
		return "/board/detail";
	}
}




