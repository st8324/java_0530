package day22.practice.student.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import day22.practice.student.vo.Student;

public class StudentManager implements Program{

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
		int grade=1, classNum=1, num=1;
		switch(menu) {
		case 1:
			printAll();
			break;
		case 2:
			//검색할 학년 입력
			System.out.print("grade : ");
			grade = sc.nextInt();
			printGrade(grade);
			break;
		case 3:
			//검색할 학년, 반, 번호 입력
			System.out.print("grade : ");
			grade = sc.nextInt();
			System.out.print("class : ");
			classNum = sc.nextInt();
			System.out.print("number: ");
			num = sc.nextInt();
			printSearch(grade, classNum, num);
			break;
		case 4:
			break;
		default:
		}
		
	}

	private void printSearch(int grade, int classNum, int num) {
		for(Student tmp : list) {
			if(tmp.equals(new Student(grade, classNum, num, ""))) {
				System.out.println(tmp);
			}
		}
	}

	private void printGrade(int grade) {
		for(Student tmp : list) {
			if(tmp.getGrade() == grade) {
				System.out.println(tmp);
			}
		}
	}

	private void printAll() {
		for(Student tmp : list) {
			System.out.println(tmp);
		}
	}

}
