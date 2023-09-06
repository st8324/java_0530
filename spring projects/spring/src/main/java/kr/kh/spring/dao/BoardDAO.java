package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikeVO;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO board);

	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectBoardCount(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("bo_num")Integer bo_num);

	void updateBoardViews(@Param("bo_num")Integer bo_num);

	void insertFile(@Param("file")FileVO fileVo);

	boolean updateBoard(@Param("board")BoardVO board);

	FileVO selectFile(@Param("fi_num")Integer num);

	void deleteFile(@Param("fi_num")Integer num);

	void deleteBoard(@Param("bo_num")Integer bo_num);

	LikeVO selectLike(@Param("li_bo_num")int li_bo_num, @Param("li_me_id")String li_me_id);

	void insertLike(@Param("like")LikeVO likeVo);

	void updateLike(@Param("like")LikeVO likeVo);

}
