package day27.attendance.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day26.library.vo.LoanBrowsing;
import day27.attendance.vo.Attendance;
import day27.attendance.vo.AttendanceBook;
import day27.attendance.vo.Student;

public class AttendanceController {

	private Scanner sc = new Scanner(System.in);
	
	//출석부
	private AttendanceBook book = new AttendanceBook();
	
	public void run() {
		int menu;
		String fileName = "src/day27/attendance/attendancebook.txt";
		load(fileName);
		do {
			System.out.println("=======================");
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			System.out.println("=======================");
		}while(menu != 4);
		save(fileName);
	}
	
	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 출석 체크");
		System.out.println("3. 출석 확인");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			attendanceCheck();
			break;
		case 3:
			printAttendance();
			break;
		case 4:
			break;
		default:
		}
	}
	private void insertStudent() {
		//정보(학번, 이름) 입력
		System.out.print("학번 : ");
		String num = sc.next();
		
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		//출석부에 새 학생을 추가
		//입력받은 정보를 이용하여 학생 객체를 생성
		Student std = new Student(num, name);
		//생성된 학생 객체를 출석부에 추가
		boolean insertSuccess = book.insertStudent(std);
		
		//추가에 성공하면 성공했다고, 실패하면 실패했다고 출력
		System.out.println("=======================");
		if(insertSuccess) {
			System.out.println("학생 정보 추가 성공!");
		}else {
			System.out.println("학생 정보 추가 실패!");
		}
	}
	private void attendanceCheck() {
		//날짜 입력
		System.out.print("날짜(yyyy-MM-dd) : ");
		String dateStr = sc.next();
		
		//날짜가 제대로 입력됐는지 체크
		//SimpleDateFormat을 이용
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("날짜 형식이 아닙니다.");
			return;
		}
		
		//출석부에서 학생 정보들을 가져와서 저장
		//=>AttendanceBook에 학생정보들을 가져오도록 추가 작업
		List<Student> stdList = book.getStdList();
		//반복문
		for(Student tmp : stdList) {
			//학생정보를 출력
			System.out.print(tmp + " : ");
			//학생의 출결을 입력(O or X)
			char state;
			do {
				state = sc.next().charAt(0);
			}while(state != 'O' && state != 'X');
			
			//출석부에 체크
			//학생정보, 출결을 이용하여 출석 객체를 생성
			//나중에 학생 삭제 기능이 추가되도 기존 출석 기록은 삭제되면 안되기 때문에 복사 
			//생성자를 이용
			Attendance attendance = new Attendance(date, new Student(tmp), state);
			//출석부에 출석 객체를 추가
			//AttendanceBook에 출석 객체가 주어지면 출석명단에 추가하는 작업
			if(!book.insertAttendance(attendance)) {
				System.out.println("이미 등록된 출석입니다.");
			}else {
				System.out.println("출석체크를 했습니다.");
			}
		}
	}
	private void printAttendance() {
		//출석부에 있는 모든 출석 정보를 확인
		book.printAttendance();
	}
	void load(String fileName) {
		try(ObjectInputStream ois 
			= new ObjectInputStream(new FileInputStream(fileName))){
			book = (AttendanceBook)ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
		} catch (EOFException e) {
			System.out.println("불러오기 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("AttendanceBook 클래스를 찾을 수 없습니다.");
		} 
	}
	void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(book);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}





