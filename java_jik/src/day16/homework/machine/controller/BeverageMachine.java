package day16.homework.machine.controller;

import java.util.Scanner;

import day16.homework.machine.vo.Beverage;

public class BeverageMachine {

	private Scanner sc = new Scanner(System.in);
	private Beverage list[] = new Beverage[3];
	
	private int money;//자판기에 있는 금액
	
	private final static int SPRITE = 0;
	private final static int COKE = 1;
	private final static int FANTA = 2;
	private final static int EXIT = 4;
	
	public BeverageMachine() {
		list[COKE] = new Beverage("콜라", 1200, 10);
		list[SPRITE] = new Beverage("사이다", 1100, 10);
		list[FANTA] = new Beverage("환타", 1000, 10);
	}
	
	public void run() {
		int menu;
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			System.out.println("============");
			
			//메뉴에 따른 기능 실행
			runMenu(menu);
		}while(menu != EXIT);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertCoin();
			break;
		case 2:
			selectBeverage();
			break;
		case 3:
			insertBeverage();
			break;
		case 4:
			break;
		default:
			System.out.println("잘못된 메뉴!");	
		}
		
	}

	private void insertBeverage() {
		System.out.println("1. 사이다");
		System.out.println("2. 콜라");
		System.out.println("3. 환타");
		System.out.print("음료 선택 : ");
		int selectBeverage = sc.nextInt() - 1;
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		switch (selectBeverage) {
		case COKE:
		case SPRITE:
		case FANTA:
			store(selectBeverage, amount);
			break;
		default:
			System.out.println("잘못 선택!");
			return;
		}
	}

	private void store(int selectBeverage, int amount) {
		if(amount < 0) {
			System.out.println("수량 오류!");
			return;
		}
		int remainAmount = list[selectBeverage].getAmount();
		list[selectBeverage].setAmount(remainAmount+amount);
		System.out.println("입고 완료!");
		
	}

	private void selectBeverage() {
		System.out.println("1. 사이다 : " + list[SPRITE].getPrice());
		System.out.println("2. 콜라  : " + list[COKE].getPrice());
		System.out.println("3. 환타  : " + list[FANTA].getPrice());
		System.out.print("음료 선택 : ");
		int selectBeverage = sc.nextInt() - 1;
		switch (selectBeverage) {
		case COKE:
		case SPRITE:
		case FANTA:
			generate(selectBeverage);
			break;
		default:
			System.out.println("잘못 선택!");
			return;
		}
	}

	private void generate(int beverage) {
		int amount = list[beverage].getAmount();
		if(amount<0) {
			System.out.println("제고 없음!");
			return;
		}
		int money =list[beverage].getPrice(); 
		if(this.money < money) {
			System.out.println("금액 부족!");
			return;
		}
		
		list[beverage].setAmount(amount-1);
		this.money -= money;
		
		System.out.println(getBeverage(beverage)+"가 나옴");
		System.out.println("거스름돈 : " + this.money);
		this.money = 0;
	}
	private String getBeverage(int beverage) {
		switch(beverage) {
		case SPRITE: return "사이다";
		case COKE: return "콜라";
		case FANTA: return "환타";
		default: return "없음";
		}
	}
	private void insertCoin() {
		System.out.print("금액 투입 : ");
		int money = sc.nextInt();
		this.money += money;
		
	}

	private void printMenu() {
		System.out.println("============");
		System.out.println("금액 : " + money);
		System.out.println("============");
		System.out.println("메뉴");
		System.out.println("1. 금액 투입");
		System.out.println("2. 메뉴 선택");
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
}









