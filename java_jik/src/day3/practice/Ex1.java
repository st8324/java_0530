package day3.practice;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		/* 성적을 입력받아 입력받은 성적이 60점이상인지 확인하는 코드를 작성하세요.
		 * (day3.practice패키지 Ex1)
		 * 예:
		 * input score :
		 * 65
		 * Do you pass 65 points? true
		 * input score :
		 * 45
		 * Do you pass 45 points? false
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("input score : ");
		int score = sc.nextInt();
		
		boolean result = score >= 60;
		System.out.println("Do you pass " + score + " points? " + result);
		sc.close();
	}
}
