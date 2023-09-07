package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.pagination.Criteria;
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

	@Override
	public List<CommentVO> getCommentList(Criteria cri, int bo_num) {
		if(cri == null) {
			cri = new Criteria(); 
		}
		return commentDao.selectCommentList(cri, bo_num);
	}

}
