package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.CommentDAO;
import kr.kh.study.vo.CommentVO;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null || comment.getCo_me_id() == null || comment.getCo_contents()==null) {
			return false;
		}
		return commentDao.insertComment(comment);
	}
}
