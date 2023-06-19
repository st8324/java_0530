package day14.Inheritance;

import lombok.Data;

public class ClassInheritanceEx {

	public static void main(String[] args) {
		/* 스마트폰은 폰이다. => 상속
		 * 	- 스마트폰 : 자식 클래스
		 *  - 폰 : 부모 클래스
		 * 스마트폰은 카메라를 가지고 있다. => 포함
		 *  - 스마트폰 : 클래스
		 *  - 카메라 : 멤버변수
		 * 부모 클래스에게 상속 받은 기능들은 사용할 수 있다.
		 *  - 접근제어자가 public, protected인 경우
		 *  - 디폴트는 같은 패키지인 경우는 가능하나 다른 패키지이면 불가능
		 */
		SmartPhone phone1 = new SmartPhone();
		phone1.call("010-1234-5678");
		phone1.answer("02-123-4567");
		System.out.println(phone1.getNum());
		phone1.take();
		
		//다운 캐스팅 : 안되는 경우
		Phone p1 = new Phone("010-123-3456");
		//문법적으로 에러가 발생하지 않으면 예외가 발생 : 다운캐스팅이 안되는
		//경우이기 때문에.
		if(p1 instanceof SmartPhone) {
			SmartPhone c1 = (SmartPhone) p1;
			c1.call("국제번호");
		}
		//다운 캐스팅 : 되는 경우
		//업캐스팅이 된 객체 p2
		Phone p2 = new SmartPhone();//업캐스팅
		SmartPhone c2 = (SmartPhone)p2;
		c2.call("123-4567");
		
	}
}
@Data
class Phone{
	private String num = "010-1111-5555";//전화번호
	
	//전화 걸기
	public void call(String num) {
		System.out.println(num);//내가 전화를 거는 상대방 번호
		System.out.println("Calling....");
	}
	//전화 받기
	public void answer(String num) {
		System.out.println(num);//나한테 전화를 건 상대방 번호
		System.out.println("Answering...");
	}
	public Phone(String num) {
		this.num = num;
	}
	//public Phone(){} //생성자가 하나도 없으면 컴파일할 때 기본 생성자가 자동으로 추가
}
class SmartPhone extends Phone{
	Camera camera = new Camera();
	public void take() {
		camera.take();
	}
	public SmartPhone() {
		//부모 클래스의 생성자가 호출
		//super()를 이용하여 부모 클래스의 생성자를 직접호출하지 않으면
		//기본 생성자인 super()가 자동으로 추가가 되고 호출이 됨.
		//이 때, 부모클래스의 기본 생성자가 없으면 에러가 발생
		//super();//에러 발생
		super("");
	}
	@Override
	public void call(String num) {
		super.call(num);
		System.out.println("SmartPhone!");
	}
}

class Camera{
	public void take() {
		System.out.println("take a picture!");
	}
}






