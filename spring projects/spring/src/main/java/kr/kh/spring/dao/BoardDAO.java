package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardTypeVO;
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

	void updateBoardLike(@Param("bo_num")int li_bo_num);

	void updateBoardComment(@Param("bo_num")int co_bo_num);

	List<BoardTypeVO> selectBoardTypeList();

	boolean insertBoardType(@Param("bt")BoardTypeVO boardType);

	void insertBoardAuthority(@Param("ba_bt_num")int bt_num, @Param("ba_authority")String authority);

	int selectBoardCountByBoardType(@Param("bo_bt_num")int bt_num);

	int selectBoardTypeCount();

	boolean deleteBoardType(@Param("bt_num")int bt_num);

	boolean updateBoardType(@Param("bt")BoardTypeVO boardType);

	List<BoardTypeVO> selectBoardTypeListByRole(@Param("me_role")String me_role);

}
