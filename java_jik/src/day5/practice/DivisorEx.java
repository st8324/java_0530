package day5.practice;

import java.util.Scanner;

public class DivisorEx {

	public static void main(String[] args) {
		/* 정수 num를 입력받아 num의 약수를 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 num까지 1씩증가
		 * 규칙성 : i가 num의 약수이면 i를 출력
		 * 		  => num를 i로 나누었을때 나머지가 0과 같다면 i를 출력
		 */
		int num, i;//i를 초기화
		Scanner sc = new Scanner(System.in);
		
		//정수 입력
		System.out.println("input positive number : ");
		num = sc.nextInt();
		
		//반복문, i는 1부터 num까지 1씩 증가
		i = 1;
		while(i <= num) { 
			//num를 i로 나누었을때 나머지가 0과 같다면 i를 출력
			if(num % i == 0) {
				System.out.println(i);
			}
			++i;
		}
		sc.close();
		
		
	}

}
