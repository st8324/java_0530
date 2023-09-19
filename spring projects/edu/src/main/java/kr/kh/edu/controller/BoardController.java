package kr.kh.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.pagination.PageMaker;
import kr.kh.edu.service.BoardService;
import kr.kh.edu.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/list")
	public String list(Model model, Criteria cri) {
		//현재 페이지 정보에 맞는 게시글를 가져오라고 서비스에게 시킴
		List<BoardVO> list = boardService.getBoardList(cri);
		//현재 페이지 정보(검색어, 타입)에 맞는 전체 게시글 수를 가져옴
		int totalCount = boardService.getTotalCount(cri);
		//페이지네이션 페이지수
		final int DISPLAY_PAGE_NUM = 3;
		
		PageMaker pm = new PageMaker(DISPLAY_PAGE_NUM, cri, totalCount);
		
		//화면에 데이터를 전송
		model.addAttribute("list", list);
		model.addAttribute("title", "게시글 조회");
		model.addAttribute("pm", pm);
		return "/board/list";
	}
}
