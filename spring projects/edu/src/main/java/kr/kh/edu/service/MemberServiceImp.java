package kr.kh.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.edu.dao.MemberDAO;
import kr.kh.edu.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDAO memberDao;

	@Override
	public MemberVO getMember(String id) {
		return memberDao.selectMember(id);
	}
}
