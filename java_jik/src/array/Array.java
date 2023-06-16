package array;

public class Array {
	//배열 전체 출력
	public static void printArray(int arr[]) {
		System.out.print("[");
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + (i==arr.length-1?"":", "));
		}
		System.out.println("]");
	}
	//배열을 start번지부터 end-1번지까지 출력
	public static void printArray(int arr[],int start, int end) {
		System.out.print("[");
		for(int i = start; i<end; i++) {
			if(i >= arr.length) {
				break;
			}
			System.out.print(arr[i] + (i==end-1?"":", "));
		}
		System.out.println("]");
	}
	//num가 배열의 원소 중에서 0번지부터 count개 안에 있는지 확인하는 메서드
	public static boolean contains(int arr[], int num, int count) {
		for(int i=0; i<count; i++) {
			//중복되면 메서드를 종료하면서 중복됐다고 알려줌.
			if(num == arr[i]) {
				return true;
			}
		}
		//이 위치까지 왔다는건 return true를 못 만났다는 뜻이고,
		//그 말은 중복되지 않았다는 뜻
		return false;
	}
	
	public static int [] createRandomArray(int min, int max,int arr[]) {
		//max가 min보다 작으면 두 수를 교환
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		//배열이 생성되어 있지 않으면(배열이 null이면) 메서드 종료
		if(arr == null) {
			arr = new int[max - min + 1];
		}
		
		//랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메서드를 종료
		//1~3 : 3개가 4개짜리 배열에 중복되지 않게 들어갈 수 없음
		if(max - min + 1 < arr.length) {
			return null;
		}
		
		int count = 0;
		while(count < arr.length) {
			int random = (int)(Math.random()*(max - min + 1) + min);
			//중복되지 않으면 배열에 저장 후 count 증가
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
		}
		return arr;
	}
	/**주어진 배열에 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수 : 배열 =>int arr[]
	 * 리턴타입 : 중복여부 => boolean
	 * 메서드명 : arrayCheck
	 * */
	public static boolean arrayCheck(int arr[]) {
		if(arr == null) {
			return false;
		}
		//arr 배열의 다른 번지들끼리 비교해서 같은 값이 있는지 확인하는 반복문
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length;j ++) {
				//같은 번지면 건너뜀
				if(i == j) {
					continue;
				}
				//다른 번지이고 값이 같으면 중복됐다고 리턴
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		//반복문이 끝날때까지 중복이 안되면 중복이 안됐다고 리턴
		return false;
	}
	
	/**정수형 배열이 주어지면 오름차순으로 버블 정렬하는 메서드
	 * 매개변수 : 정수형 배열 => int arr[]
	 * 리턴타입 : 없음 => void
	 * 메서드명 : sort
	 * */
	public static void sort(int arr[]) {
		if(arr == null) {
			return;
		}
		for(int i = 0; i<arr.length-1; i++) {
			for(int j = 0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
}









