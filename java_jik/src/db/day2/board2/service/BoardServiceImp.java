package db.day2.board2.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day2.board2.dao.BoardDAO;
import db.day2.board2.dao.MemberDAO;
import db.day2.board2.vo.BoardVO;

public class BoardServiceImp implements BoardService{

	private BoardDAO boardDao;
	private InputStream inputStream;
	private SqlSession session;
	
	public BoardServiceImp() {
		String resource = "db/day2/board2/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession();
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertBoard(String title, String id) {
		if(boardDao.insertBoard(title,id) != 0) {
			session.commit();
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<BoardVO> getBoardList() {
		
		return boardDao.selectBoardList();
	}

}
