package day1.variable;

public class CharExample1 {

	public static void main(String[] args) {
		//변수타입 변수명;
		char ch1;
		//변수타입 변수명 = 초기값;
		char ch2 = '=';
		//변수타입 변수명1, 변수명2; //변수명1과 변수명2가 같은 타입인 경우
		char ch3, ch4;
		//변수타입 변수명1 = 초기값1, 변수명2 = 초기값2;
		// \u0000 : 16진수에 맞는 문자를 가져옴
		// 십진수 41 : 10 * 4 + 1 * 1
		// 16진수 41 : 16 * 4 + 1 * 1 == 십진수 65
		// \n : 엔터, \t : 탭키만큼 공백, \\ : \문자, \' : '문자, \" : "문자
		char ch5 = '\u0041', ch6 = 65, ch7 = '\n', ch8 = '\\';

		

	}

}
