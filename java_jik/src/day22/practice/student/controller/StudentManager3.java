package day22.practice.student.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import day22.practice.student.vo.Student;

public class StudentManager3 implements Program{

	private List<Student> list = Arrays.asList(
			new Student(1,1,1,"Hong"),
			new Student(1,1,2,"Ling"),
			new Student(2,1,1,"Park"),
			new Student(3,1,1,"Lee"),
			new Student(3,3,2,"Kim")
		);
	private Scanner sc = new Scanner(System.in);
	private static final int EXIT = 4;
	
	@Override
	public void printMenu() {
		System.out.println("1. All" );
		System.out.println("2. Grade");
		System.out.println("3. Search");
		System.out.println("4. EXIT");
		System.out.println("Select : ");
	}

	@Override
	public void run() {
		int menu;
		do {
			
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
		
	}

	@Override
	public void runMenu(int menu) {
		Stream<Student> stream = list.stream();
		switch(menu) {
		case 1:
			stream.forEach(std->System.out.println(std));
			break;
		case 2:
			//검색할 학년 입력
			System.out.print("grade : ");
			final int grade1 = sc.nextInt();
			stream
			/* filter는 매개변수로 Predicate 인터페이스의 객체가 필요
			 * Predicate를 구현한 익명클래스를 람다식으로 만든 후에 객체를 생성해서 전달
			 * std는 매개변수 이름이기 때문에 다른이름으로 수정해도 됨
			 * */
				.filter(std->std.getGrade()== grade1)
				//fileter에 있는 매개변수는 위와 아래가 같은 동작
				.filter(new Predicate<Student>() {
					@Override
					public boolean test(Student t) {
						return t.getGrade() == grade1;
					}
				})
				.forEach(std->System.out.println(std));
			break;
		case 3:
			//검색할 학년, 반, 번호 입력
			System.out.print("grade : ");
			final int grade2 = sc.nextInt();
			System.out.print("class : ");
			final int classNum2 = sc.nextInt();
			System.out.print("number: ");
			final int num2 = sc.nextInt();
			stream
				.filter(std->std.equals(new Student(grade2, classNum2, num2, null)))
				.forEach(std->System.out.println(std));
			break;
		case 4:
			break;
		default:
		}
		
	}

	private void print(Predicate<Student> p) {
		for(Student tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}

}








