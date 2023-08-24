package kr.kh.app.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;
import kr.kh.app.vo.BoardVO;

public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private BoardService boardService = new BoardServiceImp();
    
    public BoardInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		BoardVO board = new BoardVO(title, id);
		boolean ok = false;
		if(boardService.insertBoard(board)) {
			ok = true;
		}
		request.setAttribute("ok", ok);
		doGet(request, response);
	}

}
