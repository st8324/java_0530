package day2.variable;

public class CastEx {

	public static void main(String[] args) {
		//3.14는 double형 리터럴이기 때문에 int에 저장할 수 없음. 강제형변환을 해야 함.
		int pi = (int) 3.14;
		//3은 int형 리터럴이기 때문에 double형 변수에 저장할 수 있음. 자동형변환
		double num1 = 3;
		//123L은 long형 리터럴이기 때문에 int에 저장할 수 없음. 강제형변환을 해야 함.
		//실제 데이터 분실이 없어도 타입에 맞게 강제형변환을 해야 함.
		int num2 = (int) 123L;
		
		System.out.println(pi);
		System.out.println(num2);
		//1/2는 문법에는 문제가 없지만 원하는 결과를 얻기 위해서 강제형변환을 함.
		System.out.println((double)1/2);
	}

}
