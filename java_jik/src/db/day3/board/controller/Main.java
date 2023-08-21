package db.day3.board.controller;

import java.util.Scanner;

public class Main {

	private static MemberController memberController = new MemberController();
	private static BoardController boardController = new BoardController();
	
	public static void main(String[] args) {
		int menu;
		final int EXIT = 3;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			System.out.println("=================");
		}while(menu != EXIT);

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
			System.out.println("[프로그램 종료]");
			break;
		default:
			System.out.println("[잘못된 메뉴 입력]");	
		}
		
	}

	private static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 회원관리");
		System.out.println("2. 게시판관리");
		System.out.println("3. 프로그램 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
	}
	
}
