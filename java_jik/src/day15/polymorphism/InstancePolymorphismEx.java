package day15.polymorphism;

public class InstancePolymorphismEx {

	public static void main(String[] args) {
		/* TV 1대, 에어컨 2대, 라디오 3대를 객체로 생성한 후
		 * 전원을 켜는 기능을 실행해보세요. */
		RemoteControl remocon = new RemoteControl();
		/*
		TV tv = new TV();
		AirConditioner aircon1 = new AirConditioner();
		AirConditioner aircon2 = new AirConditioner();
		Radio radio1 = new Radio();
		Radio radio2 = new Radio();
		Radio radio3 = new Radio();
		
		remocon.turnOn(tv);
		remocon.turnOn(aircon1);
		remocon.turnOn(aircon2);
		remocon.turnOn(radio1);
		remocon.turnOn(radio2);
		remocon.turnOn(radio3);
		*/
		/*
		TV tv = new TV();
		AirConditioner aircons[] = new AirConditioner[2];
		Radio radios [] = new Radio[3];
				
		for(int i = 0; i<aircons.length; i++) {
			aircons[i] = new AirConditioner();
		}
		for(int i = 0; i<radios.length; i++) {
			radios[i] = new Radio();
		}
		remocon.turnOn(tv);//매개변수의 다형성
		for(AirConditioner aircon : aircons) {
			remocon.turnOn(aircon);//매개변수의 다형성
		}
		for(Radio radio : radios) {
			remocon.turnOn(radio);//매개변수의 다형성
		}*/
		//포함 다형성 예제, 객체 다형성 예제
		int tvCount = 1, airconCount = 2, radioCount = 3;
		int total = tvCount + airconCount + radioCount;
		HomeAppliances homeAppliances[] = new HomeAppliances[total];
		int count = 0;//현재 만들어진 제품 대수
		//tv 1대 생성
		for(int i = 0; i < tvCount; i++ ) {
			homeAppliances[count++] = new TV();//업캐스팅
		}
		//에어컨 2대 생성
		for(int i = 0; i < airconCount; i++ ) {
			homeAppliances[count++] = new AirConditioner();//업캐스팅
		}
		//라디오 3대 생성
		for(int i = 0; i < radioCount; i++ ) {
			homeAppliances[count++] = new Radio();//업캐스팅
		}
		//모든 제품의 전원을 켬
		for(HomeAppliances homeAppliance : homeAppliances) {
			remocon.turnOn(homeAppliance);
		}
		System.out.println("==============");
		//모든 라디오의 전원을 끔
		for(HomeAppliances homeAppliance : homeAppliances) {
			//라디오로 다운캐스팅이 가능한 객체만 끔 => 라디오만 끔
			if(homeAppliance instanceof Radio) {
				remocon.turnOff(homeAppliance);//다운 캐스팅이 아님
				Radio radio = (Radio)homeAppliance;//다운 캐스팅
				System.out.println(radio.frequency);
			}
		}
	}

}

class HomeAppliances{
	boolean power;
	void turnOn() {
		power = true;
	}
	void turnOff() {
		power = false;
	}
}
class RemoteControl{
	public void turnOn(HomeAppliances appliance) {
		appliance.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOff(HomeAppliances appliance) {
		appliance.turnOff();
		System.out.println("전원이 꺼졌습니다.");
	}
}

class TV extends HomeAppliances{
	int channel;
}

class AirConditioner extends HomeAppliances{
	double CurrentTemperature;
	double desiredTemperature;
}
class Radio extends HomeAppliances{
	double frequency;
}






