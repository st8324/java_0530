package day17.practice.run;

import day17.practice.controller.ShopController;

public class Run {

	public static void main(String[] args) {
		//ShopManager를 이용하여 제품을 관리하는 프로그램을 실행
		ShopController shopManager = new ShopController();
		shopManager.run();
	}

}
