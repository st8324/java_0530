package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.MemberDAO;


@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDAO memberDao;

	@Override
	public int count() {
		return memberDao.selectCountMember();
	}
}
