package kr.kh.edu.service;

import java.util.List;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

}
