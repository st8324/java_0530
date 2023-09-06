package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.vo.CommentVO;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;
	
	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null || comment.getCo_contents() == null || comment.getCo_me_id() == null) {
			return false;
		}
		
		return commentDao.insertComment(comment);
	}

}
