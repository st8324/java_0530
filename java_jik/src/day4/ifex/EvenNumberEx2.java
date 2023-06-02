package day4.ifex;

public class EvenNumberEx2 {

	public static void main(String[] args) {
		//홀짝 판별 예제를 조건 연산자를 이용하여 작성
		int num = 3;
		String result = num % 2 == 0 ? "even" : "odd";
		System.out.println(num + " is a "+ result +" number.");
	}

}
