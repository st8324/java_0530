package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.dao.MemberDAO;
import kr.kh.app.vo.BoardVO;
import kr.kh.app.vo.MemberVO;

public class BoardServiceImp implements BoardService {

	private BoardDAO boardDao;
	private MemberDAO memberDao;
	
	public BoardServiceImp() {
		try {
			final String MYBATIS_CONFIG_PATH = "kr/kh/app/config/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			//true의 역할 : 쿼리(insert,update,delete) 실행 후 자동 커밋되게 해줌 
			SqlSession session = sf.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean insertBoard(BoardVO board) {
		if(board == null || board.getBo_me_id() == null || board.getBo_title() == null) {
			return false;
		}
		//작성자가 회원이 맞는지 확인 
		MemberVO member = memberDao.selectMember(board.getBo_me_id());
		if(member == null) {
			return false;
		}
		boardDao.insertBoard(board);
		return true;
	}

}
