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
	public boolean updateName(String name, String updateName) {
		//name과 일치하는 전화번호를 찾아야함
		//전화번호부에 수정할 이름에 해당하는 전화번호가 어디에 있는지 확인 
		int index = list.indexOf(new PhoneNumber(name,""));
		//없으면 수정이 안됨 => 메서드를 종료
		if(index == -1) {
			return false;
		}
		//찾은 전화번호의 이름을 수정 
		//전화번호부에서 이름과 일치하는 전화번호를 가져옴
		PhoneNumber pn = list.get(index);
		//가져온 전화번호의 이름을 수정
		pn.setName(updateName);
		//list.get(index).setName(updateName);
		/*
		//기본자료형은 =을 이용하면 값을 복사하기 때문에 한쪽의 값이 바뀌어도 다른쪽은
		//안바뀜
		int num1 = 1;	//num1 = 1
		int num2 = num1;//num1 = 1, num2 = 1
		num2 = 10;		//num1 = 1, num2 = 10
		//참조변수는 =을 이용하면 주소값을 복사하기 때문에 한쪽의 값이 바뀌면 다른쪽도 바뀜(공유)
		//예를 들면 pn1에 저장된 주소가 0x1000
		PhoneNumber pn1 = new PhoneNumber("a", "010-1234-5678");
		//pn1에 저장된 주소 : 0x1000, pn2에 저장된 주소 : 0x1000
		PhoneNumber pn2 = pn1;
		//0x1000번지에 있는 객체의 name을 Lim으로 수정
		pn2.setName("Lim");
		*/
		return true;
	}
	
	//전화번호 수정 : 번호
	public boolean updateNumber(String name, String number) {
		//name과 일치하는 전화번호부를 찾음
		int index = list.indexOf(new PhoneNumber(name, number));
		//일치하는 전화번호부가 없으면 수정 실패
		if(index == -1) {
			return false;
		}
		
		//number가 전화번호 패턴이 맞는지 확인하기 위해서
		//전화번호 패턴이 맞으면 전화번호 객체를 생성 했을 때 전화번호가 있고, 
		//패턴이 맞지 않으면 빈 문자열이 있다.
		//name과 number를 이용하여 전화번호 객체를 생성하는 대신 checkNumber를 이용
		//number가 전화번호 패턴이면 전화번호를 수정
		if(!PhoneNumber.checkNumber(number)) {
			return false;
		}
		list.get(index).setNumber(number);
		return true;
	}
	//전화번호 수정 : 이름, 번호
	public boolean update(String name, String updateName, String number) {
		PhoneNumber pn = new PhoneNumber(name, number);
		//name을 이용하여 전화번호부 검색
		int index = list.indexOf(pn);
		//없으면 수정 실패
		if(index == -1) {
			return false;
		}
		//number가 전화번호 패턴에 안맞으면 실패
		if(!PhoneNumber.checkNumber(number)) {
			return false;
		}
		//기존에 있는 전화번호를 삭제
		list.remove(index);
		//updateName과 number를 이용하여 전화번호 객체를 생성한 후 추가
		pn.setName(updateName);
		list.add(pn);
		return true;
	}
	//전화번호 삭제 
	public boolean delete(String name) {
		//name으로 PhoneNumber 객체를 생성 후 삭제 요청
		return list.remove(new PhoneNumber(name, ""));
	}
	//전화번호 출력
	public void print(Predicate<PhoneNumber> p) {
		for(PhoneNumber pn : list) {
			if(p.test(pn)) {
				System.out.println(pn);
			}
		}
	}
}










