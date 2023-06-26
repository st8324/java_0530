package day19.exception;

public class ExceptionEx1 {

	public static void main(String[] args) {
		/* num2의 값이 0이어도 오류가 표시 안됨
		 * 하지만, 예외가 발생해서 프로그램이 중단.(ArithmeticException이 발생)
		 * 코드상으로 오류가 표시되지 않지만 의도치 않게 프로그램이 중단되는 경우
		 * =>RuntimeException
		 * */
		int num1 = 1, num2 = 0;
		
		System.out.println(num1/num2);
	}
}
class A implements Cloneable{
	/* clone 메서드를 오버라이딩 하기 위해서 Object 클래스의 clone을 호출하면
	 * CloneNotSupportedException이 발생할 수 있다.
	 * CloneNotSupportedException는 RuntimeException 클래스의 자식 클래스가 아니다.
	 * => 반드시 예외처리를 해야함.
	 * */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public void test() /*throws ArithmeticException*/ {
		System.out.println(1/0);
	}
}





