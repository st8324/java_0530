package kr.kh.study.service;

import java.util.List;

import kr.kh.study.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList();

	BoardVO getBoard(Integer bo_num);

	void updateViews(Integer bo_num);

}
