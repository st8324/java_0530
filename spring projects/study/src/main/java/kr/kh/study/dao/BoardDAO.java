package kr.kh.study.dao;

import java.util.List;

import kr.kh.study.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList();

}
