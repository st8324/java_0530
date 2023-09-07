package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.CommentVO;

public interface CommentService {

	boolean insertComment(CommentVO comment);

	List<CommentVO> getCommentList(Criteria cri);

}
