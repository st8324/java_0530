package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.vo.BoardVO;

public interface BoardService {

	boolean insertBoard(BoardVO board);

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(int bo_num);

	boolean deleteBoard(int bo_num);

	boolean updateBoard(BoardVO board);

}
