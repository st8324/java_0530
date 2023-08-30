package kr.kh.study.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.study.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);

	boolean insertMember(@Param("m")MemberVO member);


}
