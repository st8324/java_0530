package kr.kh.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectCountBoardList(@Param("cri")Criteria cri);

}
