package day19.random;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		/* min ~ max 사이의 랜덤한 정수 : Math.random 이용
		 * */
		int min = 1, max = 9;
		int r = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(r);
		/* min ~ max 사이의 랜덤한 정수 : Random 클래스 이용
		 * */
		Random random = new Random();//매번 다른 종자값(현재시간)을 이용하기 때문에 난수가 매번 달라짐
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
	}

}
