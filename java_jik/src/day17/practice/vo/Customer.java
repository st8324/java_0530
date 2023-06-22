package day17.practice.vo;

import lombok.Data;

@Data
public class Customer {

	//CID00001
	private String customerId;//고객이 추가되면 자동으로 발급
	private String name;
	private String phoneNumber;
	
	//고객 ID 발급을 위한 클래스 변수
	//등록된 고객수
	private static int count;
	//고객 아이디 앞부분 
	private final static String CID = "CID";
	//고객 아이디 뒷부분 숫자의 최대 길이
	private final static int MAX_SIZE = 5;
	//생성자
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		generateCustomerId();//customerId 발급이 완료.
	}

	public Customer(Customer customer) {
		this.name = customer.name;
		this.phoneNumber = customer.phoneNumber;
		this.customerId = customer.customerId;
	}

	private void generateCustomerId() {
		//1 => 00001
		//1 => "1"
		String num = ""+ ++count;//문자열 + 정수 => 문자열
		//"1".length == 1
		int length = num.length();
		for(int i = 0; i<MAX_SIZE - length; i++) {
			num = "0" + num;
		}
		
		customerId = CID+num;
	}
	
	public void print() {
		System.out.println("고객번호 : " + customerId);
		System.out.println("고객이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
}







