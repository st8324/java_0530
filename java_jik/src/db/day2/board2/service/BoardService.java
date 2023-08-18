package db.day2.board2.service;

import java.util.ArrayList;

import db.day2.board2.vo.BoardVO;

public interface BoardService {

	boolean insertBoard(String title, String id);

	ArrayList<BoardVO> getBoardList();

}
