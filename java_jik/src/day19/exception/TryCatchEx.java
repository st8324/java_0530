package day19.exception;

public class TryCatchEx {

	public static void main(String[] args) {
		/* catch는 최소 1개는 필요.
		 * 어떤 예외가 발생할지 모를 때에는 Exception을 이용
		 * */
		
		
		try {
			//예외가 발생할 수 있는 코드
			System.out.println(1 / 0);//ArithmeticException이 발생
		}
		catch(ArithmeticException e) {
			System.out.println("예외 처리를 합니다.");
		}
		//첫번째 catch로 가서 ArithmeticException 클래스의 객체를 Exception으로 변환 가능한지 확인하고
		//가능하면 처리
		catch(Exception e) { 
			//예외처리
			System.out.println("예외처리를 합니다.");
		}
		//위에 Exception에서 모든 예외가 걸리기 때문에 아래 있는 catch를 실행할 일이 없음
		/*catch(ArithmeticException e) {
			System.out.println("예외 처리를 합니다.");
		}*/
		System.out.println("프로그램 종료");

	}

}
