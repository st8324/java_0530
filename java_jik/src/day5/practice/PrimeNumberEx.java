package day5.practice;

import java.util.Scanner;

public class PrimeNumberEx {

	public static void main(String[] args) {
		/* 정수 num를 입력받아 num가 소수인지 아닌지를 판별하는 코드를 작성하세요.
		 * 소수 : 약수가 2개인 수, 1을 제외하고 처음 구한 약수가 자신인 수
		 * 반복횟수 : i는 1부터 num까지 1씩증가
		 * 규칙성 : i가 num의 약수이면 약수의 개수 count를 1증가
		 * 		  => num를 i로 나누었을때 나머지가 0과 같다면 약수의 개수 count를 1증가
		 * 반복문 종료 후 : count가 2이면 소수라고 출력, 아니면 소수가 아님이라고 출력 
		 */
		int num, i, count = 0;
		Scanner sc = new Scanner(System.in);
		//정수 입력
		System.out.println("input positive number : ");
		num = sc.nextInt();
		
		//반복문. i는 1부터 num까지 1씩 증가
		i = 1;
		while(i <= num) {
			//i가 num의 약수이면 약수의 개수 count를 1증가
			if(num % i == 0) {
				count++;
			}
			i++;
		}
		//count가 2이면 소수라고 출력, 아니면 소수가 아님이라고 출력 
		if(count == 2) {
			System.out.println(num + " is a prime number.");
		}else {
			System.out.println(num + " is not a prime number.");
		}
		sc.close();
	}

}
