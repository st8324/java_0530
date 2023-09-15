package kr.kh.edu.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.edu.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member")MemberVO member);

}
