package day8.practice;

import java.util.Scanner;

public class MethodMultipleEx {

	public static void main(String[] args) {
		//System.out.println(MethodEvenNumberEx.isMultiple(4, 2));
		int num1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input number : ");
		num1 = sc.nextInt();
		
		if(isMultiple(num1, 6)) {
			System.out.println(num1 + " is a multiple of 6.");
		}else if(isMultiple(num1, 2)) {
			System.out.println(num1 + " is a multiple of 2.");
		}else if(isMultiple(num1, 3)) {
			System.out.println(num1 + " is a multiple of 3.");
		}else {
			System.out.println(num1 + " is not a multiple of 2,3,6");
		}
		
		sc.close();
	}
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
}
