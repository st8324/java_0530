package day18.practice;

public class StringIndexOfEx {

	public static void main(String[] args) {
		/* Hello world에서 l이 몇개 있는지 확인하는 코드를 작성하세요. */
		String str = "Hello world!";
		int count = 0;
		String search ="a";
		int index = -1;
		//반복 : 찾으면 반복
		do {
			//Hello world에 l의 위치를 찾음=>lo world에서 l의 위치를 찾음 => o world엣 l의 위치 찾음
			//=>d에서 l의 위치를 찾음
			index = str.indexOf(search, ++index);
			//찾았으면 개수를 증가
			if(index != -1) {
				count++;
			}
		}while(index != -1);
		//개수를 출력
		System.out.println(str + " : " + search + " : " + count);
	}

}
