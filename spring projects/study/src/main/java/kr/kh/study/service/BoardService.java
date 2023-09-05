package kr.kh.study.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.FileVO;
import kr.kh.study.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer bo_num);

	void updateViews(Integer bo_num);

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files);

	boolean update(BoardVO board, MemberVO user, MultipartFile[] files, int[] delNums);

	boolean deleteBoard(Integer bo_num, MemberVO user);

	List<FileVO> getFileList(Integer bo_num);

	int getBoardTotalCount();

}
