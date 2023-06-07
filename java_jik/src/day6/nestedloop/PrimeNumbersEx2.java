package day6.nestedloop;

public class PrimeNumbersEx2 {

	public static void main(String[] args) {
		/* 2부터 100사이의 소수를 출력하는 코드를 작성하세요.
		 * */
		int i, j, count;
		
		/* 외부 반복문 : 2부터 숫자를 증가시키는 반복문
		 * 반복횟수 : i는 2부터 100까지 1씩 증가
		 * 규칙성 : i가 소수이면 i를 출력
		 * */
		for( i = 2 ; i <= 100 ; i++ ) {
			/* 내부 반복문 : i가 소수인지 확인하는 반복문
			 * 반복횟수 : j는 1부터 i까지 1씩 증가
			 * 규칙성 : j가 i의 약수이면 약수의 개수를 1증가
			 * 반복문 종료 후 : 약수의 개수가 2개이면 i를 출력
			 */
			for(j = 1, count = 0 ; j <= i ; j++ ) {
				if(i % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println(i);
			}
		}
	}
}
