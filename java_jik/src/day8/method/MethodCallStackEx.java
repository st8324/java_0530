package day8.method;

public class MethodCallStackEx {

	public static void main(String[] args) {
		/* 함수(메소드) 호출 스택 예제 */
		method1(1);
		//method4();//재귀 메소드를 잘못 작성한 경우 StackOverFlow가 발생
	}
	
	public static void method1(int a) {
		System.out.println(a);
		method2(a);
	}
	public static void method2(int a) {
		System.out.println(a-1);
		method3();
	}
	public static void method3() {
		System.out.println("end");
	}
	public static void method4() {
		System.out.println("a");
		method4();
	}
}





