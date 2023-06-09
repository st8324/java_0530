package day8.practice;

import java.util.Scanner;

public class MethodGCDEx {

	public static void main(String[] args) {
		int num1, num2;
		Scanner sc = new Scanner(System.in);

		System.out.println("input 2 numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int gcd = gcd(num1,num2);
		
		System.out.println(num1 + " and " + num2 + " gcd : " + gcd);
		
		sc.close();
	}
	
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}

	/**두 정수가 주어지면 두 정수의 최대 공약수를 알려주는 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 최대 공약수 => 정수 => int
	 * 메서드명 : gcd
	 */
	public static int gcd(int num1, int num2) {
		for(int i = num1; i>=1; i--) {
			//i가 num1의 약수이다 == num1은 i의 배수이다
			if(isMultiple(num1, i) && isMultiple(num2, i)) {
				return i;
			}
		}
		return 1;
	}
}






