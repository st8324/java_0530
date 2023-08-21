package db.day3.board.service;

import db.day3.board.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	boolean withdraw(MemberVO member);

	

}
