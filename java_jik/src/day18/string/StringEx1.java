package day18.string;

public class StringEx1 {

	public static void main(String[] args) {
		/* 문자열 관련 메서드 */
		//indexOf : 기준 문자열에서 검색 문자/문자열을 왼쪽부터 검색해서 처음으로 만난는 위치를 반환
		//lastIndexOf : 기준 문자열에서 검색 문자/문자열을 오른쪽부터 검색해서 처음으로 만난는 위치를 반환
		String str="Hello world";
		
		//str에서 7번지부터 wo가 있는지 확인. orld에서 wo가 있는지 확인=>없음=>-1
		int index = str.indexOf("wo", 7);
		System.out.println(str + "에서 7번지부터 " + "wo" + "가 있나요?" +index);
		
		index = str.indexOf("wo");
		System.out.println(str + "에서 0번지부터 " + "wo" + "가 있나요?" +index);
		
		index = str.indexOf("o");
		System.out.println(str + "에서 0번지부터 " + "o" + "가 있나요?" +index);
		
		//contains : 기준 문자열에서 검색 문자/문자열이 있는지 없는지를 알려줌
		boolean result = str.contains("o");
		System.out.println(str + "에서 0번지부터 " + "o" + "가 있나요?" +result);

		System.out.println(str + "의 길이는? " + str.length());
		
		//replace : 특정 문자/문자열을 바꿀 때 사용. 모두
		//replaceAll : 정규표현식에 맞는 모든 문자/문자열을 수정
		String str2 = str.replace(" ", ",");
		System.out.println(str2);
		
		//substring : 부분 문자열 추출
		String str3 = str.substring(6);
		System.out.println(str + "에서 6번지부터 가져온 부분 문자열 : " + str3);
		
		//lastIndexOf : 기준 문자열에서 검색 문자/문자열을 오른쪽부터 검색해서 처음으로 만난는 위치를 반환
		index = str.lastIndexOf("o");
		System.out.println(str + "에서 0번지부터 " + "o" + "가 오른쪽부터 있나요?" +index);
		
		//toLowerCase : 소문자로
		System.out.println(str + " : 소문자 :  " +str.toLowerCase());
		//toUpperCase : 대문자로
		System.out.println(str + " : 소문자 :  " +str.toUpperCase());
		
		//trim 시작문자(a) 전 공백, 마지막문자(f) 후 공백을 제거, 사이에 있는 공백은 제거 못함
		String str4 = "\n\t\tabc\t\tdef\t\n";
		System.out.println(str4.trim());
		
		//split : 구분자를 기준으로 문자열을 추출해서 순서대로 배열에 저장
		String str5 = "사과,배,포도";
		String fruits[] = str5.split(",");
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
	}

}
