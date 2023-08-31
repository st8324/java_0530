package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

public interface BoardService {

	boolean insertBoard(BoardVO board, MemberVO user);

	List<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

}
