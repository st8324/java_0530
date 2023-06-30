package day22.practice.phone.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class PhoneBook {

	//전화번호 리스트
	private List<PhoneNumber> list = new ArrayList<>();
	
	//전화번호 추가
	public boolean insertPhone(String name, String number) {
		//이름과 전화번호를 이용하여 전화번호 객체를 생성
		PhoneNumber pn = new PhoneNumber(name, number);
		//전화번호가 비어 있으면 => 전화번호 패턴에 맞지 않으면 저장 X
		if(pn.getNumber().length() == 0) {
			return false;
		}
		//전화번호가 패턴에 맞으면 전화번호부에 번호를 추가
		list.add(pn);
		return true;
	}
	
	//전화번호 수정 : 이름
	
	//전화번호 수정 : 번호
	
	//전화번호 수정 : 이름, 번호
	
	//전화번호 삭제 
	
	//전화번호 출력
	public void print(Predicate<PhoneNumber> p) {
		for(PhoneNumber pn : list) {
			if(p.test(pn)) {
				System.out.println(pn);
			}
		}
	}
}










