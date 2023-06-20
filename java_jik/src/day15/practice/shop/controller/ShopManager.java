package day15.practice.shop.controller;

import java.util.Scanner;

import day15.practice.shop.vo.Product;

public class ShopManager {

	private Scanner sc = new Scanner(System.in);
	private Product list[] = new Product[10];//제품 리스트
	private int count = 0;//저장된 제품 개수
	
	public void run() {
		System.out.println("프로그램 시작!!");
		
		int menu = -1;
		final int EXIT = 6;
		//반복 : 선택한 메뉴가 종료가 아닐때
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = sc.nextInt();
			
			//선택한 메뉴에 따른 기능을 실행
			runMenu(menu);
			
		}while(menu != EXIT);
		System.out.println("프로그램 종료!!");
	}
	
	private void printMenu() {
		System.out.println("================");
		System.out.println("메뉴");
		System.out.println("1. 제품 판매");
		System.out.println("2. 제품 입고");
		System.out.println("3. 제품 조회");
		System.out.println("4. 매출 조회");
		System.out.println("5. 고객 등록");
		System.out.println("6. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	private void runMenu(int menu) {
		System.out.println("================");
		
		switch(menu) {
		case 1:	
			sell();
			break;
		case 2:
			store();
			break;
		case 3:	
			printProduct();
			break;
		case 4:	
			printSales();
			break;
		case 5:	
			registerCustomer();
			break;
		case 6:	
			break;
		default:
			System.out.println("잘못된 메뉴!");
		}
	}

	private void registerCustomer() {
		// TODO Auto-generated method stub
		
	}

	private void printSales() {
		// TODO Auto-generated method stub
		
	}

	private void printProduct() {
		// TODO Auto-generated method stub
		
	}

	private void store() {
		
		//입고할 제품명 입력
		System.out.print("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//입고할 제품 수량
		System.out.print("수량  : ");
		int amount = sc.nextInt();
		
		if(amount < 0) {
			System.out.println("입고 수량 오류!");
			return;
		}
		
		//제품 리스트에서 입고할 제품명이 있는지 찾음
		//제품 배열에 있는 제품명과 입고할 제품명이 같은지를
		//확인해서 같으면 위치를 기억
		int index = indexOf(name);
		
		//있으면 입고할 제품 수량 만큼 해당 제품에 입고
		//위치가 0이상이면 
		if(index != -1) {
			list[index].store(amount);
			System.out.println("입고 완료!");
			return;
		}
		//없으면 제품 리스트에 제품 정보를 추가(입고할 수량도 함께)
		//위치가 -1이면
		//최대치로 등록되어 있으면
		if(count == list.length) {
			System.out.println("제품 리스트 다참!");
			return;
		}
		//모델명 입력
		System.out.println("새 제품 등록");
		System.out.print("모델명 : ");
		sc.nextLine();
		String modelName = sc.nextLine();
		//가격을 입력
		System.out.print("가격  : ");
		int price = sc.nextInt();
		//분류 입력
		System.out.print("분류  : ");
		String category = sc.next();
		
		//제품 리스트에 추가
		list[count++] = new Product(name, modelName, price, amount, category);
		
		System.out.println("제품 추가 후 입고 완료!");
	}

	/**제품 리스트에 제품명과 일치하는 제품이 있으면 번지를, 없으면
	 * -1을 알려주는 메서드
	 * 매개변수 : 제품명 => String name
	 * 리턴타입 : 제품이 있는 번지나 -1 => 정수 => int
	 * 메서드명 : indexOf
	 * */
	public int indexOf(String name) {
		for(int i = 0; i < count ; i++) {
			if(list[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	private void sell() {
		// TODO Auto-generated method stub
		
	}
}






