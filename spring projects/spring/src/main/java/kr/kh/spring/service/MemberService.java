package kr.kh.spring.service;

import kr.kh.spring.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	void updateMemberSession(MemberVO user);

	MemberVO getMemberBySession(String session_id);

	boolean sendMail(String to, String title, String contents);

	Object checkId(String id);

}
