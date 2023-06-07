package day6.nestedloop;

public class MultiplicationTableEx {

	public static void main(String[] args) {
		//구구단 2단부터 9단까지 출력하는 코드를 작성하세요.
		int i, j = 0;
		/* 외부 반복문
		 * 반복횟수 : i는 2부터 9까지 1씩 증가.
		 * 규칙성 : i단이 출력  
		 * */
		for( i = 2 ; i <= 9 ; i++ ) {
			//i단 출력
			/* 내부 반복문
			 * 반복횟수 : j는 1부터 9까지 1씩 증가
			 * 규칙성 : i x j = i*j를 출력
			 * */
			for( j = 1; j<=9; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
		}
		//이 위치에서 i와 j이 값은 얼마? i : 10, j : 10
		System.out.println("i : " + i + ", j : " + j);
	}

}
