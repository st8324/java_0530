package day10.practice;

public class PointEx {
	
	public static void main(String[]args) {
		/* 좌표의 점을 관리하는 클래스를 만들고 테스트하는 코드를 작성하세요. 
		 * 필요한 속성과 기능을 생각해서 추가해보세요.(예: 그림판 하단의 좌표)
		 */
		Point pt1 = new Point();
		pt1.print();
		pt1.move(10, 20);
		pt1.print();
		
		Point pt2 = new Point(30,40);
		pt2.print();
	}
}
//점을 관리하는 클래스
/* 클래스의 접근제어자가 public으로 올 수 있는 조건
 * - 파일명과 클래스명이 같아야 public을 붙일 수 있음
 * 같은 패키지에 같은 이름의 클래스가 있으면 안됨.
 * */
class Point{
	//멤버변수
	/* x좌표, y좌표 */
	private int x, y;
	
	//생성자
	public Point() {}
	//생성자 오버로딩. x,y좌표가 주어졌을 객체를 초기화
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//getter와 setter(메서드에 포함)
	
	/* getter
	 * public 리턴타입 get변수명(){
	 * 		return 변수명;
	 * }
	 * get변수명에서 변수명의 첫 글자를 대문자
	 * 리턴타입은 변수의 자료형
	 * 
	 * setter
	 * public void set변수명(자료형 변수명){
	 * 		this.변수명 = 변수명;
	 * }
	 * */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//메서드
	/**현재 좌표를 출력하는 메서드
	 * 매개변수 : 없음.
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print
	 * */
	public void print() {
		System.out.println("" + x + "," + y + "px");
	}
	/**주어진 x,y좌표로 이동하는 메서드
	 *  =>멤버변수 x,y를 주어진 x,y로 수정하는 메서드
	 * 매개변수 : 주어진 x,y => int x,int y
	 * 리턴타입 : 없음 => void
	 * 메서드명 : move
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}













