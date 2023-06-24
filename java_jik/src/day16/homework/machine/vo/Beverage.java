package day16.homework.machine.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor//모든 멤버를 매개변수로 하는 생성자 추가
public class Beverage {
	private String name;
	private int price;
	private int amount;
	
	public void store(int amount) {
		if(amount < 0) {
			return;
		}
		this.amount += amount;
	}
	
	/*
	public Beverage(String name, int price, int amount){
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	*/
}
