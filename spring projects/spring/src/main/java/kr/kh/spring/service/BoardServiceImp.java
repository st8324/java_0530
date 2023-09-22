package kr.kh.spring.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.util.UploadFileUtils;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	
	@Resource
	String uploadPath;

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
		
			//첨부파일을 서버에 업로드 하고, DB에 저장
		uploadFileAndInsert(files, board.getBo_num());
		
		return true;
	}

	private void uploadFileAndInsert(MultipartFile[] files, int bo_num) {
		if(files == null || files.length == 0) {
			return;
		}
		for(MultipartFile file : files) {
			if(file == null || file.getOriginalFilename().length() == 0) {
				continue;
			}
			try {
				String fi_name = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(bo_num, fi_name, file.getOriginalFilename());
				boardDao.insertFile(fileVo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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

	@Override
	public boolean updateBoard(BoardVO board, MultipartFile[] files, Integer[] delFiles, MemberVO user) {
		if(board == null || board.getBo_title()==null || board.getBo_title().length() == 0 ) {
			return false;
		}
		//게시글 정보를 가져옴(로그인한 회원과 작성자가 같은지 확인을 위해) 
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//db에 해당 게시글이 없거나 게시글 작성자와 로그인한 회원이 다른 경우
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		if(!boardDao.updateBoard(board)) {
			return false;
		}
		//첨부파일 업데이트 
		//추가된 첨부파일을 서버에 업로드 및 DB에 추가
		uploadFileAndInsert(files, board.getBo_num());
		
		//삭제된 첨부파일을 서버에서 제거 및 DB에서 제거
		deleteFile(delFiles);
		return true;
	}

	private void deleteFile(Integer[] delFiles) {
		if(delFiles == null || delFiles.length == 0) {
			return;
		}
		
		for(Integer num : delFiles) {
			if(num == null) {
				continue;
			}
			//첨부파일 정보를 가져옴
			FileVO fileVo = boardDao.selectFile(num);
			if(fileVo == null) {
				continue;
			}
			UploadFileUtils.deleteFile(uploadPath, fileVo.getFi_name());
			//DB에서 제거 
			boardDao.deleteFile(num);
		}
		
	}

	@Override
	public boolean deleteBoard(Integer bo_num, MemberVO user) {
		if(bo_num == null || user == null) {
			return false;
		}
		BoardVO board = boardDao.selectBoard(bo_num);
		//없는 게시글이거나 작성자가 아니면 
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//첨부파일 삭제
		List<FileVO> fileList = board.getFileVoList();
		deleteFile(fileList);
		//게시글 삭제 
		boardDao.deleteBoard(bo_num);
		return true;
	}

	private void deleteFile(List<FileVO> fileList) {
		if(fileList == null || fileList.size() == 0) {
			return;
		}
		//List<FileVO> => Integer[]
		Integer [] nums = new Integer[fileList.size()];
		for(int i = 0; i<nums.length; i++) {
			nums[i] = fileList.get(i).getFi_num();
		}
		deleteFile(nums);
	}

	@Override
	public int like(LikeVO likeVo) {
		if(likeVo == null || likeVo.getLi_me_id() == null) {
			return -100;
		}
		//기존 추천 정보를 가져옴(게시글 번호와 아이디)
		LikeVO dbLikeVo = boardDao.selectLike(likeVo.getLi_bo_num(), likeVo.getLi_me_id());
		
		//기존 추천 정보가 없으면
		if(dbLikeVo == null) {
			//추가
			boardDao.insertLike(likeVo);
		}
		else {//있으면
			//db에 있는 추천 상태와 화면에 누른 추천 상태가 같으면 => 취소 
			if(dbLikeVo.getLi_state() == likeVo.getLi_state()) {
				likeVo.setLi_state(0);
			}
			//업데이트
			boardDao.updateLike(likeVo);
		}
		boardDao.updateBoardLike(likeVo.getLi_bo_num());
		return likeVo.getLi_state();
	}

	@Override
	public LikeVO getBoardLike(Integer bo_num, MemberVO user) {
		if(bo_num == null || user == null) {
			return null;
		}
		return boardDao.selectLike(bo_num, user.getMe_id());
	}

	@Override
	public List<BoardTypeVO> getBoardTypeList() {
		return boardDao.selectBoardTypeList();
	}

	@Override
	public boolean insertBoardType(BoardTypeVO boardType) {
		if(boardType == null || boardType.getBt_title() == null || boardType.getBt_authority() == null) {
			return false;
		}
		//게시판명이 중복되는걸 방지하기 위해
		try {
			boolean res = boardDao.insertBoardType(boardType);
			if(!res) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		switch (boardType.getBt_authority()) {
		case "USER":
			boardDao.insertBoardAuthority(boardType.getBt_num(), "USER");
		case "ADMIN":
			boardDao.insertBoardAuthority(boardType.getBt_num(), "ADMIN");
			break;
		}
		return true;
	}

	@Override
	public boolean deleteBoardType(BoardTypeVO boardType) {
		if(boardType == null) {
			return false;
		}
		//등록된 게시글이 있는지 확인 
		int count = boardDao.selectBoardCountByBoardType(boardType.getBt_num());
		//있으면 삭제 실패
		if(count != 0) {
			return false;
		}
		//등록된 게시판 타입이 몇개 있는지 확인
		int btCount = boardDao.selectBoardTypeCount();
		
		//1개 있으면 삭제 실패 
		if(btCount == 1) {
			return false;
		}
		//게시판 타입을 삭제
		return boardDao.deleteBoardType(boardType.getBt_num());
	}

	@Override
	public boolean updateBoardType(BoardTypeVO boardType) {
		if(boardType == null || boardType.getBt_title() == null) {
			return false;
		}
		try {
			return boardDao.updateBoardType(boardType);
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<BoardTypeVO> getBoardTypeList(MemberVO user) {
		if(user == null || user.getMe_role() == null) {
			return null;
		}
		return boardDao.selectBoardTypeListByRole(user.getMe_role());
	}
}






