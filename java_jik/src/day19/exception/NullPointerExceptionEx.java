package day19.exception;

public class NullPointerExceptionEx {

	public static void main(String[] args) {
		/* NullPointerException
		 * - 객체가 null인 상태로 메서드, 멤버를 호출하는 경우 발생
		 * */
		String str = null;
		//String str = "abc";
		System.out.println(str.substring(0));
		test(str);
	}

	/* 메서드를 만들 때 매개변수의 null체크를 반드시 하는게 좋다. */
	public static void test(String str) {
		if(str == null) {
			return;
		}
		System.out.println(str.substring(0));
	}
}
