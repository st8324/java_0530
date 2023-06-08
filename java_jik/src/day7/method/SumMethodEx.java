package day7.method;

public class SumMethodEx {

	public static void main(String[] args) {
		/* 두 정수의 합을 구하는 함수(메서드)를 만드세요.
		 */
		int num1 = 1, num2 = 2;
		int res = sum(num1, num2);
		System.out.println(res);
	}
	/** 
	 * 기능    : 두 정수가 주어지면 두 정수의 합을 알려주는 메서드 
	 * 메서드명 : sum 
	 * 리턴타입 : 두 정수의 합 => int
	 * 매개변수 : 두 정수 => int num1, int num2
	 * @return
	 */
	/**
	 * 기능    : 두 정수가 주어지면 두 정수의 합을 알려주는 메서드
	 * @param num1 정수1
	 * @param num2 정수2
	 * @return 두 정수의 합
	 */
	public static int sum(int num1, int num2) {
		int res = num1 + num2;
		return res;
		//return num1 + num2;
	}
	
}




