package kr.kh.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.FileVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectCountBoardList(@Param("cri")Criteria cri);

	boolean insertBoard(@Param("board")BoardVO board);

	void insertFile(@Param("file")FileVO fileVo);

	BoardVO selectBoard(@Param("num")int num);

	List<FileVO> selectFileList(@Param("num")int num);

}
