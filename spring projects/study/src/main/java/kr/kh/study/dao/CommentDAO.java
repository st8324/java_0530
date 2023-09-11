package kr.kh.study.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.study.vo.CommentVO;

public interface CommentDAO {

	boolean insertComment(@Param("comment")CommentVO comment);

}
