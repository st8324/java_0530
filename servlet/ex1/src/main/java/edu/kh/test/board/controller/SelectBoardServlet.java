package edu.kh.test.board.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.kh.test.board.model.dao.BoardDAO;
import edu.kh.test.board.model.vo.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	BoardDAO boardDao;   
    
	public SelectBoardServlet() {
		try {
			final String MYBATIS_CONFIG_PATH = "edu/kh/test/board/config/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = sf.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspName = "/WEB-INF/views/searchSuccess.jsp";
		try {
			int num = Integer.parseInt(request.getParameter("search"));
			BoardDTO board = boardDao.selectBoard(num);
			request.setAttribute("board", board);
			if(board == null) {
				jspName = "/WEB-INF/views/searchFail.jsp";
			}
		}catch(Exception e) {
			jspName = "/WEB-INF/views/searchFail.jsp";
		}
		request.getRequestDispatcher(jspName).forward(request, response);
	}

}
