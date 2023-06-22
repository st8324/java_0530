package day17.practice.vo;

import lombok.Data;

@Data
public class Product {
	//멤버 변수 : 제품 판매와 관련된 제품 정보
	private String name;//제품명
	private String modelName;//모델명
	private int price;//가격
	private int amount;//수량(판매 수량, 전체 제고량)
	private String category;//분류
	
	//생성자
	public Product(String name, String modelName, int price, int amount, String category) {
		this.name = name;
		this.modelName = modelName;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}
	
	public Product(Product product) {
		this.name = product.name;
		this.modelName = product.modelName;
		this.price = product.price;
		this.amount = product.amount;
		this.category = product.category;
	}

	public Product(String search) {
		this.name = search;
	}

	//메서드
	/**제품 입고 기능 => 현재 수량에 주어진 수량을 누적*/
	public void store(int amount) {
		//창고에 제품을 추가해야하는데 음수가 오면 안됨
		if(amount < 0) {
			return;
		}
		accumulate(amount);
	}
	/**제품 출고 기능 => 현주 수량에서 주어진 수량을 감소*/
	public void release(int amount) {
		if(amount < 0) {
			return;
		}
		accumulate(-amount);
	}
	private void accumulate(int amount) {
		this.amount += amount;
	}

	public void print() {
		System.out.println("제품명 : " + name);
		System.out.println("모델명 : " + modelName);
		System.out.println("분류  : " + category);
		System.out.println("제고  : " + amount);
		System.out.println("가격  : " + price);
	}
}









