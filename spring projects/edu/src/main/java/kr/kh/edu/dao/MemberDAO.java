package kr.kh.edu.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.edu.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member")MemberVO member);

	MemberVO selectMember(@Param("id")String id);

	void updateMemberSession(@Param("member")MemberVO user);

	MemberVO selectMemberBySessionId(@Param("session_id")String sId);

}
