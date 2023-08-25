package kr.kh.app.service;

import java.util.List;

import kr.kh.app.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList();

	BoardVO getBoard(Integer bo_num);

}
