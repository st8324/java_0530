package day7.homework;

public class StarEx5 {

	public static void main(String[] args) {
		/*    *		i=1	공=3			*=1
		 *   ***	i=2	공=2			*=3
		 *  *****	i=3	공=1			*=5
		 * *******	i=4	공=0			*=7
		 * 				공=half-i	*=2*i-1
		 *  *****	i=5	공=1			*=5 = 2*3-1
		 *   ***	i=6	공=2			*=3 = 2*2-1
		 *    *		i=7	공=3			*=1 = 2*1-1
		 *    			공=i-half	*= 2*(num+1-i)-1=2*(num-i)+1
		 */
		int num = 11;
		for(int i = 1; i<=num; i++) {
			int half = (num + 1) / 2;
			//4줄 => (num + 1) / 2
			if(i <= half) {
				//half-i개 공백 출력
				for(int j = 1; j<=half-i; j++) {
					System.out.print(' ');
				}
				//2*i-1개 * 출력
				for(int j = 1; j<=2*i-1; j++) {
					System.out.print('*');
				}
				//엔터
				System.out.println();
			}
			//3줄
			else {
				//i-half개 공백 출력
				for(int j = 1; j<=i-half; j++) {
					System.out.print(' ');
				}
				//2*(num-i)+1개 * 출력
				for(int j = 1; j<=2*(num-i)+1; j++) {
					System.out.print('*');
				}
				//엔터
				System.out.println();
			}
		}
	}

}
