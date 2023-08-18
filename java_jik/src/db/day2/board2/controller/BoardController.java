package db.day2.board2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import db.day2.board2.service.BoardService;
import db.day2.board2.service.BoardServiceImp;
import db.day2.board2.vo.BoardVO;

public class BoardController {
	
	private Scanner sc;
	private BoardService boardService;
	
	public BoardController(Scanner sc) {
		this.sc = sc;
		boardService = new BoardServiceImp();
	}

	public void run() {
		//게시글 등록, 수정, 삭제, 게시글 리스트 조회
		int menu;
		final int EXIT = 5;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertBoard();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			printBoardList();
			break;
		case 5:
			break;
		default:
			System.out.println("[잘못된 메뉴]");
		}
		
	}

	private void printBoardList() {
		ArrayList<BoardVO> list = boardService.getBoardList();
		for(BoardVO tmp : list) {
			System.out.println(tmp);
		}
	}

	private void insertBoard() {
		//제목, 작성자 id
		System.out.print("제목 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("ID  : ");
		String id = sc.next();
		if(boardService.insertBoard(title, id)) {
			System.out.println("[게시글 작성 성공!]");
		}else {
			System.out.println("게시글 작성 실패!");
		}
	}

	private void printMenu() {
		System.out.println("=====게시판 메뉴=====");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.게시글 확인");
		System.out.println("5.뒤로가기");
		System.out.println("==================");
		System.out.print("메뉴 선택 : ");
	}

}
