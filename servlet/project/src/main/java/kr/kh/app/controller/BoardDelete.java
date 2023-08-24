package kr.kh.app.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService= new BoardServiceImp();
    
    public BoardDelete() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bo_num = Integer.parseInt(request.getParameter("bo_num"));
		String msg = "게시글 삭제 실패!";
		String redirectUrl = "/board/detail?bo_num=" + bo_num;
		if(boardService.deleteBoard(bo_num)) {
			msg = "게시글 삭제 성공!";
			redirectUrl = "/list";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", redirectUrl);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
