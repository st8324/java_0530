package day21.practice.updown.controller;

import java.util.Scanner;

public class GameManager implements Program {

	//리터럴 3에 이름을 붙여서 명확하게 전달하기 위해.
	private static final int EXIT = 3;
	
	//다른 메서드에서 매번 객체를 생성하는게 번거로워서
	private Scanner sc = new Scanner(System.in);

	@Override
	public void printMenu() {

		System.out.println("1. Play");
		System.out.println("2. Record");
		System.out.println("3. EXIT");
		System.out.print("Select Menu : ");
		
	}

	@Override
	public void run() {
		System.out.println("Program Start!!");
		
		int menu;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case 1:
			playGame();
			break;
		case 2:
			recordGame();
			break;
		case 3:break;
		default:
			System.out.println("Wrong menu!");
		}
		
	}

	private void recordGame() {
		// TODO Auto-generated method stub
		
	}

	private void playGame() {
		// TODO Auto-generated method stub
		
	}

}
