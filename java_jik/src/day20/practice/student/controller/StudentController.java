package day20.practice.student.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day20.practice.student.vo.Student;

public class StudentController implements Program {

	private final static int EXIT = 4;
	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<Student> list = new ArrayList<>();
	
	@Override
	public void run() {
		System.out.println("Program Start!");
		
		int menu;
		
		do {
			try {
				System.out.println(list);
				printMenu();
				menu = sc.nextInt();
				
				runMenu(menu);
			}catch(InputMismatchException e) {
				menu = EXIT-1;//종료 메뉴가 아닌 아무 메뉴를 추가
				sc.nextLine();//앞에서 잘못 입력한 내용을 비워줌
				System.out.println("Wrong Input!");
			}
		}while(menu != EXIT);
	}
	@Override
	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1. Insert Student");
		System.out.println("2. Update Studnet");
		System.out.println("3. Delete Student");
		System.out.println("4. EXIT");
		System.out.print("Menu Select : ");
	}
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:	break;
		default:
		}
	}
	private void deleteStudent() {
		//삭제할 학생 정보를 입력(학년, 반, 번호)
		System.out.print("grade : ");
		int grade = sc.nextInt();
		System.out.print("class : ");
		int classNum = sc.nextInt();
		System.out.print("number: ");
		int number = sc.nextInt();
		
		//삭제할 학생정보를 이용하여 학생 객체를 생성
		Student tmp = new Student(grade, classNum, number, null);
		
		//삭제를 시도해서 성공하면 성공했다고, 실패하면 실패했다고 알려줌
		if(list.remove(tmp)) {
			//삭제 성공
			System.out.println("Delete success!!");
			return;
		}
		System.out.println("Delete fail");
	}
	private void updateStudent() {
		//수정할 학생의 정보를 입력(학년, 반, 번호)
		System.out.print("grade : ");
		int grade = sc.nextInt();
		System.out.print("class : ");
		int classNum = sc.nextInt();
		System.out.print("number: ");
		int number = sc.nextInt();
		
		
		//수정할 학생이 있는지 없는지 확인.
		//학생 객체를 생성
		Student tmp = new Student(grade, classNum, number, null);
		int index = list.indexOf(tmp);
		//없으면 종료
		if(index == -1) {
			System.out.println("Update fail!!");
			return;
		}
		
		//수정될 학생 정보를 입력(학년, 반, 번호, 이름)
		System.out.print("grade : ");
		grade = sc.nextInt();
		System.out.print("class : ");
		classNum = sc.nextInt();
		System.out.print("number: ");
		number = sc.nextInt();
		System.out.print("name  : ");
		sc.nextLine();//number를 입력하고 난 뒤 엔터를 처리하기 위해
		String name = sc.nextLine();
		
		//학생 정보를 수정
		//수정될 학생 정보가 이미 있는 학생인지 확인 
		//수정될 정보를 이용하여 학생 객체를 생성
		tmp = new Student(grade, classNum, number, name);
		//학년,반,번호가 일치하는 학생이 있는지 확인해서 있으면 종료
		if(list.contains(tmp)) {
			System.out.println("Update fail!!");
			return;
		}
		list.get(index).update(grade, classNum, number, name);
	}
	private void insertStudent() {
		//추가할 학생의 정보를 입력(학년, 반, 번호, 이름)
		System.out.print("grade : ");
		int grade = sc.nextInt();
		System.out.print("class : ");
		int classNum = sc.nextInt();
		System.out.print("number: ");
		int number = sc.nextInt();
		System.out.print("name  : ");
		sc.nextLine();//number를 입력하고 난 뒤 엔터를 처리하기 위해
		String name = sc.nextLine();
		
		//입력을 정보를 이용하여 학생 객체를 생성
		Student std = new Student(grade, classNum, number, name);
		
		//학생리스트에 추가
		//학생이 있는지 없는지 확인(학년, 반, 번호)해서 없으면 추가
		if(!list.contains(std)) {
			list.add(std);
			System.out.println("Insert success!!");
			return;
		}
		
		//추가 성공하면 추가했다고, 실패하면 실패했다고 콘솔에 출력
		System.out.println("Insert fail!!");
		
	}
}




