package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.vo.BoardVO;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);

	ArrayList<BoardVO> selectBoardList();

	BoardVO selectBoard(@Param("bo_num")int bo_num);

}
