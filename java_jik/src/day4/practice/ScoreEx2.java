package day4.practice;

import java.util.Scanner;

public class ScoreEx2 {

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
		
		/* score가 0미만이거나 100초과이면 wrong score!
		 * score가 90이상이면 A
		 * score가 80이상이면 B
		 * score가 70이상이면 C
		 * score가 60이상이면 D
		 * 아니면 F
		 * */
		if(score < 0 || score > 100) {
			System.out.println("wrong score!");
		} else if(score >= 90) {
			System.out.println("A");
		} else if(score >= 80) {
			System.out.println("B");
		} else if(score >= 70) {
			System.out.println("C");
		} else if(score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		sc.close();
	}

}
