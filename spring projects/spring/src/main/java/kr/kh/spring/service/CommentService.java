package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.CommentVO;

public interface CommentService {

	boolean insertComment(CommentVO comment);

	List<CommentVO> getCommentList(Criteria cri, int bo_num);

	int getTotalCount(int bo_num);

	boolean deleteComment(CommentVO comment);

	boolean updateComment(CommentVO comment);

}
