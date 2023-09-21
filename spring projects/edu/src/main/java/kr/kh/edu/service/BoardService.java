package kr.kh.edu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.FileVO;
import kr.kh.edu.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] fileList);

	BoardVO getBoard(int num);

	List<FileVO> getFileList(int num);

}
