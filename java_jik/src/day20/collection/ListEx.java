package day20.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		//1부터 5까지 차례대로 추가
		for(int i = 1; i<= 5; i++) {
			list.add(i);//정수 i가 박싱으로 Integer 클래스의 객체가 된 후 list에 추가
		}
		//1을 더 추가
		list.add(1);
		System.out.println(list);
		//1을 제거
		boolean res = list.remove((Integer)1);//첫번째 만나는 1을 제거하고 제거가 되어서 true를 반환
		System.out.println(res);
		System.out.println(list);
		//1번지에 있는 객체를 제거(3을 제거)
		Integer num = list.remove(1);//1번지에 있는 요소를 제거하고 제거한 요소를 반환
		System.out.println(num);
		System.out.println(list);
		System.out.println(list.size());//저장된 객체 수를 출력. 저장 가능한 최대 객체 수가 아님.
		
		//일반. 리스트는 특정 번지에 접근할 수 있어서 get()을 이용하여 반복문을 활용할 수 있다.
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		//향상된 for문. List와 Set 모두 가능
		for(int tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//Iterator
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		System.out.println(list.contains(1));//List에 1이 있는지 없는지 확인
		System.out.println(list.indexOf(1));//List에 1이 몇번지에 있는지 확인
	}

}



