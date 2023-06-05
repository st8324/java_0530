package day5.practice;

import java.util.Scanner;

public class PrintMenuEx {

	public static void main(String[] args) {
		//메뉴를 출력하는 예제
		/* 반복횟수 : menu가 3이 아닐때까지 
		 * 규칙성 : 
		 * - 메뉴를 출력
		 * - 메뉴를 입력
		 * - 입력받은 메뉴에 따라 콘솔에 출력
		 *   - 입력받은 메뉴가 1이면 Program Start!
		 *   - 입력받은 메뉴가 2이면 Program Save!
		 *   - 입력받은 메뉴가 3이면 Program Exit!
		 */
		int menu = 0; //3이 아닌 값으로 초기화
		Scanner sc = new Scanner(System.in);
		while(menu != 3) {
			//메뉴를 출력
			System.out.println("Menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("Select Menu : ");
			
			//메뉴를 입력 
			menu = sc.nextInt();
			
			//입력받은 메뉴에 따라 콘솔에 출력
			switch(menu) {
			//입력받은 메뉴가 1이면 Program Start!
			case 1:
				System.out.println("Program Start!");
				break;
			//입력받은 메뉴가 2이면 Program Save!
			case 2:
				System.out.println("Program Save!");
				break;
			//입력받은 메뉴가 3이면 Program Exit!
			case 3:
				System.out.println("Program Exit!");
				break;
			}
		}
		sc.close();
	}

}
