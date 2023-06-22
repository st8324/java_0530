package day17.interfaceex;

import day13.homework.controller.VocabularyNoteController;
import day15.practice.shop.controller.ShopManager;

public class InterfaceEx {

	public static void main(String[] args) {
		/* 인터페이스를 이용하여 객체를 생성할 수 없음. */
		//RunInterface run = new RunInterface();
		System.out.println(RunInterface.NUM);
		//구현 클래스는 객체를 생성할 수 있다.
		Run run = new Run();
		run.run();
		run.load();
		//구현클래스로 생성한 객체를 RunInterface가 관리
		RunInterface runInterface = new Run();
		runInterface.run();
		//RunInterface에는 load가 추상메서드로 존재하지 않기 때문에 에러가 발생
		//runInterface.load(); 
		//아래 코드는 Run클래스의 객체로 클래스변환이 됐기 때문에 load()메서드를 호출할 수 있음
		((Run)runInterface).load();
		run(new ShopManager());//단어장, 판매관리
		//run(new VocabularyNoteController());
	}

	/* 인터페이스 매개변수 다형성
	 * - 매개변수를 인터페이스의 객채로 선언하면, 
	 * 	 호출할 때 매개변수로 구현 클래스들의 객체들이 올 수 있음.
	 *   => 다양한 클래스들의 객체가 올 수 있다.
	 * - RunInterface의 객체를 매개변수로 하면, RunInterface를 구현한
	 *   구현 클래스인 ShopManager, VocabularyNoteController의 객체가
	 *   와서 프로그램을 실행할 수 있다. 
	 */
	public static void run(RunInterface program) {
		//프로그램 실행
		program.run();
	}
}


interface Stop{
	void stop();
}

//구현 클래스 : 인터페이스를 구현한 클래스
//구현 클래스는 인터페이스의 모든 추상 메서드를 반드시 오버라이딩해야함.
//구현 클래스는 여러 인터페이스를 구현할 수 있다.
class Run implements RunInterface, Stop{

	public void load() {
		System.out.println("loading....");
	}
	
	@Override
	public void run() {
		System.out.println("Program start!");
		stop();
	}

	@Override
	public void stop() {
		System.out.println("Program Stop!");
	}
}








