package kr.kh.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.MemberVO;

public interface BoardService {

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files);

	List<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

	BoardVO getBoard(Integer bo_num);

	void updateViews(Integer bo_num);

	boolean updateBoard(BoardVO board, MultipartFile[] files, Integer[] delFiles, MemberVO user);

	boolean deleteBoard(Integer bo_num, MemberVO user);

	int like(LikeVO likeVo);

	LikeVO getBoardLike(Integer bo_num, MemberVO user);

	List<BoardTypeVO> getBoardTypeList();

	boolean insertBoardType(BoardTypeVO boardType);

	boolean deleteBoardType(BoardTypeVO boardType);

	boolean updateBoardType(BoardTypeVO boardType);

	List<BoardTypeVO> getBoardTypeList(MemberVO user);

}
