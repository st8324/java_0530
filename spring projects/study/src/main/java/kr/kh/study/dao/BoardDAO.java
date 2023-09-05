package kr.kh.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.FileVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("bo_num")Integer bo_num);

	void updateBoardViews(@Param("bo_num")Integer bo_num);

	boolean insertBoard(@Param("board")BoardVO board);

	boolean updateBoard(@Param("board")BoardVO board);

	boolean deleteBoard(@Param("bo_num")Integer bo_num);

	void insertFile(@Param("file")FileVO fileVo);

	List<FileVO> selectFileList(@Param("bo_num")Integer bo_num);

	void deleteFile(@Param("fi_num")int fi_num);

	FileVO selectFile(@Param("fi_num")int fi_num);

	int selectBoardTotalCount();

}
