package day4.homework;

import java.util.Scanner;

public class ScoreAverageEx {

	public static void main(String[] args) {
		
		int kor, eng, math;
		double avg;
		Scanner sc = new Scanner(System.in);

		//국어, 영어, 수학순으로 성적을 입력
		System.out.println("input score (kor, eng, math, ex : 100 90 80) : ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		//평균을 계산
		avg = (kor + eng + math) / (double)3.0;//(double)로 형변환도 가능. 3.0을 이용도 가능
		
		//평균을 출력
		System.out.println("avg : " + avg);
		
		sc.close();
	}

}
