package db.day3.board.service;

import java.util.List;

import db.day3.board.vo.BoardVO;

public interface BoardService {

	boolean insertBoard(BoardVO board);

	List<BoardVO> getBoardList();

	boolean updateBoard(BoardVO board);

	boolean deleteBoard(BoardVO board);

}
