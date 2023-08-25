package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;
import kr.kh.app.vo.BoardVO;

public class BoardList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
    
    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list = boardService.getBoardList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
