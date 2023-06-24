package day18.homework.arithmetic.controller;

import java.util.Scanner;

public class ArithmeticEx implements Program {

	//프로그램 종료 번호를 클래스 상수로 설정. 객체마다 만들필요가 없어서 
	private final static int EXIT = 3;
	
	private Scanner sc = new Scanner(System.in);
	
	//두 정수와 산술 연산자, 연살 결과
	private int num1, num2;
	private char operator;
	private double res;
	
	@Override
	public void run() {

		int menu;
		do {
			
			printMenu();
			
			menu = sc.nextInt();
			
			System.out.println("===============");
			
			runMenu(menu);
			
		}while(menu != EXIT);
		
	}

	@Override
	public void printMenu() {
		System.out.println("===============");
		System.out.println("1. Input Integer.");
		System.out.println("2. Input Operator");
		System.out.println("3. EXIT");
		System.out.print("Select Menu : ");
		
	}

	@Override
	public void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			InputNumber();
			break;
		case 2:
			InputOperator();
			break;
		case 3:
			System.out.println("EXIT!");
			break;
		default:
			System.out.println("Wrong menu!");
		}
	}
	//두 정수 입력
	private void InputOperator() {
		System.out.print("Input operator : ");
		operator = sc.next().charAt(0);
		//산술 연산자가 아닌 경우.
		if(!checkOperator(operator)) {
			System.out.println("Wrong Operator!");
			return;
		}
		//연산 후 결과 출력
		calculator();
		
	}
	//산술 연산을 하고, 결과를 출력하는 메서드.
	private void calculator() {
		switch (operator) {
		case '+':	res = num1 + num2;	break;
		case '-':	res = num1 - num2;	break;
		case '*':	res = num1 * num2;	break;
		case '/':	res = num1 / (double)num2;	break;
		case '%':	res = num1 % num2;	break;
		default:
			System.out.println("Wrong Operator!");
			return;
		}
		System.out.println(num1 + " " + operator + " " + num2 + " = " + res);
	}

	//연산자가 산술 연산자인지 아닌지 알려주는 메서드
	private boolean checkOperator(char operator) {
		switch(operator) {
		case '+','-','*','/','%':
			return true;
		}
		return false;
	}

	//산술 연산자 입력
	private void InputNumber() {
		System.out.print("Input 2 Integer Number : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
	}
	

	

}
