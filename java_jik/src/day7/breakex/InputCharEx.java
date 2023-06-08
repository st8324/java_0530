package day7.breakex;

import java.util.Scanner;

public class InputCharEx {

	public static void main(String[] args) {
		// q를 입력하면 반복문을 종료하는 예제
		
		char ch;
		Scanner sc = new Scanner(System.in);

		for( ; ; ) {
			System.out.println("input char (eixt : q) : ");
			ch = sc.next().charAt(0);
			if(ch == 'q') {
				break;
			}
		}
		
		sc.close();
	}

}
