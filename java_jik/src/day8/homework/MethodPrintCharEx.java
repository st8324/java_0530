package day8.homework;

public class MethodPrintCharEx {

	public static void main(String[] args) {
		/* 다음과 같이 출력하기 위한 코드를 작성하세요.
		 * 단, 메서드 이용
		 * *****
		 * ***
		 * ?????
		 * ^^^^^^^
		 */
		printString("*****");
		printChar('*', 5);
		System.out.println();
		printChar('*', 5, '\n');
		printChar('=',6,'\n');
		/*     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 * */
		int num = 5;
		for(int i = 1; i<=num; i++) {
			//공백(' ')이 num - i개 출력 
			printChar(' ', num - i);
			//'*'이 i개 출력 후 엔터
			printChar('*', i, '\n');
		}
	
	}
	/**문자열이 주어지면 주어진 문자열을 출력하고 줄바꿈 하는 메서드
	 * 매개변수 : 문자열 => String str
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printString
	 * */
	public static void printString(String str) {
		System.out.println(str);
	}
	
	/**문자와 개수가 주어지면 주어진 문자를 개수만큼 출력 하는 메서드
	 * 매개변수 : 문자와 개수 => char ch, int count
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printChar
	 * */
	public static void printChar(char ch, int count) {
		for(int i = 1; i<=count; i++) {
			System.out.print(ch);
		}
	}
	
	/**문자와 개수, 마지막 문자가 주어지면 주어진 문자를 개수만큼 출력하고 마지막 문자를 출력 하는 메서드
	 * 매개변수 : 문자와 개수, 마지막 문자 => char ch, int count, char lastCh
	 * 리턴타입 : 출력된 문자열 => String
	 * 메서드명 : printChar
	 * 메서드 오버로딩으로 printChar 메서드 추가
	 * */
	public static String printChar(char ch, int count, char lastCh) {
		String str = "";
		for(int i = 1; i<=count; i++) {
			System.out.print(ch);
			str += ch;
		}
		System.out.print(lastCh);
		str += lastCh;
		return str;
	}
}








