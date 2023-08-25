package kr.kh.app.dao;

import java.util.List;

import kr.kh.app.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList();

}
