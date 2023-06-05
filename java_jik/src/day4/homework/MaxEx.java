package day4.homework;

import java.util.Scanner;

public class MaxEx {

	public static void main(String[] args) {
		
		int num1, num2;
		int max; //두 수 중 큰 수를 저장할 변수
		Scanner sc = new Scanner(System.in);
		//두 정수를 입력
		System.out.println("input 2 integer numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		//큰 수를 max에 저장
		//num1이 num2보다 크거나 같으면 max에 num1를 저장
		if(num1 >= num2) {
			max = num1;
		}
		//아니면 max에 num2를 저장
		else {
			max = num2;
		}
		//max를 출력
		System.out.println("The greater number of "+ num1 +" or "+ num2 +" is " + max);
		max = 100;
		max = num1 >= num2 ? num1 : num2;
		System.out.println("The greater number of "+ num1 +" or "+ num2 +" is " + max);
		sc.close();
	}

}
