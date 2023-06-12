package day9.classex;

public class CarMain {

	public static void main(String[] args) {
		/* 현대 뉴 아반떼 2023년식 자동차 객체를 생성하는 코드를 작성하세요.
		 * */
		Car myCar = new Car("The new AVANTE","Hyundai",2023);
		//현재 내 차 정보를 조회
		myCar.turn();
		myCar.setGear('D');
		myCar.printInfo();
		myCar.speedChagne(false);
		myCar.speedChagne(false);
		myCar.speedChagne(false);
		myCar.printInfo();
		myCar.speedChagne(true);
		myCar.speedChagne(true);
		myCar.speedChagne(true);
		myCar.printInfo();
		myCar.speedChagne(false);
		myCar.printInfo();
		
	}
}