package day2.operator;

public class ArithmeticEx {

	public static void main(String[] args) {
		int num1 = 1, num2 = 2;
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)num1 / num2;//1/2의 결과가 0이어서, 1.0/2로 바꾸어 0.5가 나오게 함
		int mod = num1 % num2;
		
		System.out.println("" + num1 + '+' + num2 + "=" + sum);
		System.out.println("" + num1 + '-' + num2 + "=" + sub);
		System.out.println("" + num1 + '*' + num2 + "=" + mul);
		System.out.println("" + num1 + '/' + num2 + "=" + div);
		System.out.println("" + num1 + '%' + num2 + "=" + mod);
		
		int res = 0;
		//1 + res = 2;//대입연산자 = 왼쪽에 식이 와서 에러가 발생
		res = 2 - 1;//대입연산자 = 오른쪽에 식이 와서 에러 없이 잘 실행
		//1 = res + 1;//대입연산자 = 왼쪽에는 리터럴이 올 수 없음

	}

}
