package day19.homework;

import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//두 정수와 산술연산자 입력
		System.out.print("input (ex:1 + 2) :");
		try {
			int num1 = sc.nextInt();
			char op = sc.next().charAt(0);
			int num2 = sc.nextInt();
			
			String message = "{0} {1} {2} = {3}";
			
			double res = calculate(num1, op, num2);
			
			String result = MessageFormat.format(message, num1, op, num2, res);
			System.out.println(result);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println("Exception!!");
		}
		sc.close();
	}
	public static double calculate(int num1, char op, int num2) 
		throws ArithmeticException{
		//연산자에 따를 결과를 출력
		switch(op) {
		case '+':	return num1 + num2;
		case '-':	return num1 - num2;
		case '*':	return num1 * num2;
		case '/':
			if(num2 == 0) {
				throw new ArithmeticException("It should not be divided by zero.");
			}
			return num1 / (double)num2;
		case '%':	
			if(num2 == 0) {
				throw new ArithmeticException("It should not be divided by zero.");
			}
			return num1 % num2;
		default:
			throw new ArithmeticException("Wrong operator");
		}
	}
	
}
