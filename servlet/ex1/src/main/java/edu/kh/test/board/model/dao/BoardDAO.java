package edu.kh.test.board.model.dao;

import edu.kh.test.board.model.vo.BoardDTO;

public interface BoardDAO {

	BoardDTO selectBoard(int num);

}
