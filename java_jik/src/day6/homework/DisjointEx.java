package day6.homework;

import java.util.Scanner;

public class DisjointEx {

	public static void main(String[] args) {
		/* 두 정수를 입력받아 두 정수가 서로소 관계인지 판별하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 num1까지 1씩 증가
		 * 규칙성 : i가 num1의 약수이고 i가 num2의 약수이면 i를 gcd에 저장 
		 * 		  num1을 i로 나누었을 때 나머지가 0과 같고
		 * 		  num2를 i로 나누었을 때 나머지가 0과 같다면
		 * 		  i를 gcd에 저장
		 * 반복문 종료 후 : gcd가 1이면 Disjoint를 출력하고,
		 * 				아니면 Not disjoint를 출력
		 */
		int num1, num2, i = 1, gcd = 1;
		Scanner sc = new Scanner(System.in);
		//두 정수를 입력
		System.out.println("input 2 numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		//반복문(최대공약수를 구하기 위한) : i가 num1까지
		for(i=1, gcd = 1 ;i <= num1; i++) {
			//num1을 i로 나누었을 때 나머지가 0과 같고 num2를 i로 나누었을 때 나머지가 0과 같다면 i를 gcd에 저장
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
			
		}
		//gcd가 1이면 Disjoint를 출력하고, 아니면 Not disjoint를 출력
		if(gcd == 1) {
			System.out.println("Disjoint!");
		}else {
			System.out.println("Not disjoint!");
		}
		sc.close();
	}

}








