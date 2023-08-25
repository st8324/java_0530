package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList();

	BoardVO selectBoard(@Param("bo_num")Integer bo_num);

}
