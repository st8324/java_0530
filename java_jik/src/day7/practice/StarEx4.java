package day7.practice;

public class StarEx4 {

	public static void main(String[] args) {
		/*     *		i=1	공=4		*=1	*=0
		 *    ** *		i=2	공=3		*=2	*=1
		 *   *** **		i=3	공=2		*=3	*=2
		 *  **** ***	i=4	공=1		*=4	*=3
		 * ***** ****	i=5	공=0		*=5	*=4
		 * 					공=5-i	*=i	*=i-1
		 * */
		/* 외부 반복문
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : * i개를 출력후 엔터
		 * */
		for(int i = 1; i<=5; i++) {
			//공백을 출력
			/* 내부 반복문
			 * 반복횟수 : j는 1부터 5-i까지 1씩 증가
			 * 규칙성 : ' '를 출력
			 * */
			for(int j = 1; j<=5-i; j++) {
				System.out.print(' ');
			}
			
			//* i개를 출력
			/* 내부 반복문
			 * 반복횟수 : j는 1부터 i까지 1씩 증가
			 * 규칙성 : *을 출력 
			 */
			for(int j = 1; j<=i; j++) {
				System.out.print('*');
			}
			//* i-1개를 출력
			/* 내부 반복문
			 * 반복횟수 : j는 1부터 i-1까지 1씩 증가
			 * 규칙성 : *을 출력 
			 */
			for(int j = 1; j<=i-1; j++) {
				System.out.print('*');
			}

			//엔터
			System.out.println();
		}
	}

}
