package kr.kh.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.MemberVO;

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
	@GetMapping("/board/insert")
	public String boardInsert() {
		return "/board/insert";
	}
	@PostMapping("/board/insert")
	public String boardInserPost(Model model, BoardVO board, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		
		boolean res = boardService.insertBoard(board, user);
		if(res) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/board/list");
		}else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/board/insert");
		}
		
		return "/util/message";
	}
}




