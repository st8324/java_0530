package kr.kh.app.service;

import kr.kh.app.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	boolean withdraw(MemberVO member);



}
