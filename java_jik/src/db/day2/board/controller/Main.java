package db.day2.board.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static Connection con = null; 
	private static MemberController memberController;
	private static BoardController boardController;
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String dbId = "root";
		String dbPw = "root";
		
		con = connect(url, dbId, dbPw);
		if(con != null) {
			System.out.println("[연결 성공!]");
		}else {
			System.out.println("[연결 실패!]");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(con, sc);
		boardController = new BoardController(con, sc);
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			//메뉴 실행
			runMenu(menu);
		}while(menu != EXIT);
		
		sc.close();
		close(con);
	}
	
	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			memberController.run();
			break;
		case 2:
			boardController.run();
			break;
		case 3:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
		
	}

	private static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 회원 메뉴");
		System.out.println("2. 게시판 메뉴");
		System.out.println("3. 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
	}

	private static Connection connect(String url, String id, String pw) {
		try {
			return DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			return null;
		}
	}
	private static void close(Connection con) {
		try {
			//연결한 connection을 닫아줌
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {}
	}
	
}
