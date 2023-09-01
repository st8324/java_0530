package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title()==null || board.getBo_title().length() == 0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		if(!boardDao.insertBoard(board)) {
			return false;
		}
		//첨부파일을 업로드
		if(files == null || files.length == 0) {
			return true;
		}
		for(MultipartFile file : files) {
			//uploadFileAndInsert(file);
			if(file != null) {
				System.out.println(file.getOriginalFilename());
			}
		}
		return true;
	}

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
		return boardDao.selectBoardCount(cri);
	}

	@Override
	public BoardVO getBoard(Integer bo_num) {
		if(bo_num == null) {
			return null;
		}
		return boardDao.selectBoard(bo_num);
	}

	@Override
	public void updateViews(Integer bo_num) {
		if(bo_num == null) {
			return;
		}
		boardDao.updateBoardViews(bo_num);
	}
}






