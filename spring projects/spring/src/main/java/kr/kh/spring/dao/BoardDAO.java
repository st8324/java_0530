package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardVO;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO board);

	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectBoardCount(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("bo_num")Integer bo_num);

	void updateBoardViews(@Param("bo_num")Integer bo_num);

}
