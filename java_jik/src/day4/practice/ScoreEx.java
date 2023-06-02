package day4.practice;

import java.util.Scanner;

public class ScoreEx {

	public static void main(String[] args) {
		/* 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * 90이상 ~ 100이하 : A
		 * 80이상 ~ 90미만 : B
		 * 70이상 ~ 80미만 : C
		 * 60이상 ~ 70미만 : D
		 * 60미만 : F
		 * 0보다 작거나 100보다 큰 경우 : wrong score
		 * */
		int score;
		Scanner sc = new Scanner(System.in);
		System.out.println("input score");
		score = sc.nextInt();
		
		//90이상 ~ 100이하 : A
		//score가 90이상이고 score가 100이하이면 A라고 출력
		//score가 90보다 크거나 같고 score 100보다 작거나 같으면 A라고 출력
		if(score >= 90 && score <= 100) {
			System.out.println("A");
		} else if(score >= 80 && score < 90) {
			System.out.println("B");
		} else if(score >= 70 && score < 80) {
			System.out.println("C");
		} else if(score >= 60 && score < 70) {
			System.out.println("D");
		} else if(score >= 0 && score < 60) {
			System.out.println("F");
		} else {
			System.out.println("wrong score!");
		}
		
		sc.close();
	}

}
