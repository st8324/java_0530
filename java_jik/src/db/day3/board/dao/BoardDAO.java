package db.day3.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.day3.board.vo.BoardVO;

public interface BoardDAO {

	int insertBoard(@Param("board")BoardVO board);

	List<BoardVO> selectBoardList();

	BoardVO selectBoard(@Param("bo_num")int bo_num);

	int updateBoard(@Param("board")BoardVO dbBoard);

	boolean deleteBoard(@Param("bo_num")int bo_num);

}
