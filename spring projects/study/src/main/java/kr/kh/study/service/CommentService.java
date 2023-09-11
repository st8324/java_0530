package kr.kh.study.service;

import java.util.List;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.vo.CommentVO;

public interface CommentService {

	boolean insertComment(CommentVO comment);

	List<CommentVO> getCommentList(int bo_num, Criteria cri);

	int getTotalCount(int bo_num);

}
