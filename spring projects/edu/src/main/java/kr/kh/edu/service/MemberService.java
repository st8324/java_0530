package kr.kh.edu.service;

import kr.kh.edu.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	boolean checkId(String id);

	MemberVO login(MemberVO member);

	void updateMemberSession(MemberVO user);

	MemberVO getMemberBySessionId(String value);

}
