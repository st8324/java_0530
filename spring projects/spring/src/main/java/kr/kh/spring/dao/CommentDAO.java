package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.CommentVO;

public interface CommentDAO {

	boolean insertComment(@Param("comment")CommentVO comment);

	List<CommentVO> selectCommentList(@Param("cri")Criteria cri, @Param("bo_num")int bo_num);

	int selectCommentCount(@Param("bo_num")int bo_num);

	boolean deleteComment(@Param("comment")CommentVO comment);

	boolean updateComment(@Param("comment")CommentVO comment);

}
