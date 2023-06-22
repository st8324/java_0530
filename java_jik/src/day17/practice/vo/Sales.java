package day17.practice.vo;

import lombok.Data;

@Data
//판매 내역 : 누가 어떤 제품을 샀는지 관리하는 클래스
public class Sales {

	private Customer customer;
	private Product product;
	private int totalPrice;//판매 내역의 총 금액(전체 내역의 총 금액이 아님)
	
	public Sales(Customer customer, Product product) {
		this.customer = customer;
		this.product = product;
		totalPrice = product.getAmount() * product.getPrice();
	}

	public void print() {
		System.out.println("================");
		System.out.println("제품 : " + product.getName());
		System.out.println("수량 : " + product.getAmount());
		System.out.println("고객 : " + customer.getCustomerId());
		System.out.println("금액 : " + totalPrice);
		System.out.println("================");
	}
}







