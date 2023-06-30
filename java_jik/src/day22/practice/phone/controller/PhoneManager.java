package day22.practice.phone.controller;

import java.util.Scanner;

import day22.practice.phone.vo.PhoneBook;

public class PhoneManager implements Program {

	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4;
	private PhoneBook pb = new PhoneBook();
	
	@Override
	public void printMenu() {
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Search");
		System.out.println("4. EXIT");
		System.out.print("Select Menu : ");
	}

	@Override
	public void run() {
		int menu;
		do {
			System.out.println("===========");
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			System.out.println("===========");
		}while(menu != EXIT);
		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			search();
			break;
		case 4:
			System.out.println("EXIT!!");
			break;
		default:
			System.out.println("Wrong Menu!!");
		}
	}

	private void search() {
		//검색할 이름을 입력
		System.out.print("name  :");
		sc.nextLine();
		String name = sc.nextLine();
		
		//검색 결과를 출력
		pb.print(s->s.getName().contains(name));
		//pb.print(s->true);//전체 출력
	}

	private void update() {
		//이름, 수정할 이름과 수정할 전화번호를 입력
		System.out.print("name  :");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("update name  :");
		String updateName = sc.nextLine();
		
		System.out.print("number:");
		String number = sc.nextLine();
		
		//전화번호부에 수정를 해서 성공하면 성공이라고
		if(pb.update(name, updateName, number)) {
			System.out.println("Update Success!!");
		}
		//실패하면 실패했다고 출력
		else {
			System.out.println("Update Fail!!");
		}
	}

	private void insert() {
		//이름과 전화번호를 입력
		System.out.print("name  :");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("number:");
		String number = sc.nextLine();
		//전화번호부에 추가를 해서 성공하면 성공이라고
		if(pb.insertPhone(name, number)) {
			System.out.println("Insert Success!!");
		}
		//실패하면 실패했다고 출력
		else {
			System.out.println("Insert Fail!!");
		}
		
	}
}










