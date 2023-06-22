package day17.practice.service;

import day17.practice.vo.Customer;
import day17.practice.vo.Product;
import day17.practice.vo.Sales;

public class ShopServiceImp implements ShopService {

	@Override
	public int store(Product[] list, int count, Product product) {
		//입고할 제품이 없으면 입고하지 않고, 기존 제품 수를 알림.
		if(product == null) {
			return count;
		}
		//제품리스트가 없으면
		if(list == null) {
			return 0;
		}
		//제품 리스트의 크기가 count보다 작으면
		if(list.length < count) {
			return list.length;
		}
		//제품수가 잘못되면(음수이면)
		if(count < 0) {
			return 0;
		}
		
		int index = indexOf(list, count, product);
		//기존 제품 입고
		if(index != -1) {
			list[index].store(product.getAmount());
			return count;
		}
		//배열이 꽉 차면
		if(count == list.length) {
			return count;
		}
		
		//새 제품 입고
		list[count] = new Product(product);
		return count+1;
	}

	private int indexOf(Product[] list, int count, Product product) {
		//제품 정보가 없거나 제품 명이 없으면 못찾음
		if(product == null || product.getName() == null) {
			return -1;
		}
		//제품 리스트가 없으면
		if(list == null) {
			return -1;
		}
		//검색할 제품수가 잘못 입력되면 
		if(count > list.length || count < 0) {
			count = list.length;
		}
		for(int i = 0; i < count ; i++) {
			//제품 리스트에서 꺼낸 제품 정보를 tmp에 저장 
			Product tmp = list[i];
			//제품 리스트에 있는 제품이 없거나 이름이 없거나 찾을 제품명이 없으면 못찾음
			if(	tmp == null || 
				tmp.getName() == null || 
				product.getName() == null) {
				return -1;
			}
			//제품명끼리 비교하여 같으면 번지를 반환
			if(tmp.getName().equals(product.getName())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void printProduct(Product[] list, int count, String search) {
		if(list == null || search == null) {
			System.out.println("제품 정보가 없습니다.");
			return ;
		}
		
		int index = indexOf(list, count, new Product(search));
		
		if(index == -1) {
			System.out.println("제품 정보가 없습니다.");
			return ;
		}
		list[index].print();
	}

	@Override
	public int registerCustomer(Customer[] list, 
			int count, 
			Customer customer) {
		if(list == null 
			|| count < 0 
			|| customer == null
			|| customer.getPhoneNumber() == null
			|| list.length <= count) {
			return -1;
		}
		for(int i = 0; i<count; i++) {
			if(list[i].getPhoneNumber().equals(customer.getPhoneNumber())) {
				return -1;
			}
		}
		list[count] = 
			new Customer(customer);
		return count+1;
	}

	@Override
	public int sell(Product[] list, int count, Customer[] customerList, int customerCount, Sales[] salesHistory,
			int salesCount, String name, int amount, String phoneNumber) {
		//각 리스트가 존재하는지 확인
		if(list == null || customerList == null || salesHistory == null) {
			return -1;
		}
		//각 리스트의 최대 크기가 각 개수보다 크거나 같은지를 체크
		if(list.length < count 
			|| customerList.length < customerCount
			|| salesHistory.length <= salesCount) {
			return -1;
		}
		
		//제품 정보 검색
		int productIndex = indexOf(list, count, new Product(name));
		//고객 정보 검색
		int customerIndex = indexOf(customerList, customerCount, phoneNumber);
		
		if(productIndex == -1 || customerIndex == -1) {
			return -1;
		}
		//판매 정보를 생성
		Product sellProduct = new Product(list[productIndex]);
		sellProduct.setAmount(amount);
		Sales sales = new Sales(customerList[customerIndex], sellProduct);
		
		//판매된 제품의 제고량을 수정
		list[productIndex].release(amount);
		
		//판매리스트에 판매 정보를 추가
		salesHistory[salesCount] = sales;
		return salesCount + 1;
	}

	private int indexOf(Customer[] customerList, int customerCount, String phoneNumber) {
		if(customerList == null || phoneNumber == null) {
			return -1;
		}
		for(int i = 0; i < customerCount; i++) {
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void printSales(Sales[] salesHistory, int salesCount) {
		int totalPrice = 0;
		//매출 내역 출력
		for(int i =0; i<salesCount; i++) {
			salesHistory[i].print();
			totalPrice += salesHistory[i].getTotalPrice();
		}
		
		//누적 매출역 출력
		System.out.println("누적 매출액 : " + totalPrice);
		
	}

	
	
	
	
	
}
