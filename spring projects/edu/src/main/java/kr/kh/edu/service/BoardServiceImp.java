package kr.kh.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.edu.dao.BoardDAO;
import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectCountBoardList(cri);
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user) {
		if(board == null || 
			board.getBo_title() == null || board.getBo_title().trim().length() == 0 ||
			board.getBo_contents() == null) {
			return false;
		}
		//작성자가 없으면 안되기 때문
		if(user == null) {
			return false;
		}
		//게시글 작성자를 로그이한 회원 아이디로 수정
		board.setBo_me_id(user.getMe_id());
		//게시글을 DB에 저장
		boolean res = boardDao.insertBoard(board);
		
		if(!res) {
			return false;
		}
		//첨부파일 등록
		
		return true;
	}
}
