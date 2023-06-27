package day20.generic;

import java.util.Scanner;

public class GenericEx {

	public static void main(String[] args) {
		Student<Integer> std = new Student<Integer>();
		std.kor = 10;//10.0을 넣어주면 에러가 발생
		Student<Double> std2 = new Student<Double>();
		std2.kor = 10.0;
		/*
		Student<Scanner> std3 = new Student<>();
		std3.kor = 10;
		*/
		print(std2);
		GenericEx.<Double>print(std2);
		GenericEx.print(std2);//std2가 Double로 되어 있어서 print의 T를 Double이라고 추정할 수 있어서
	}

	//학생 정보를 출력하는 메서드
	public static <T extends Number> void print(Student<T> std) {
		System.out.println(std.grade);
		System.out.println(std.classNum);
		System.out.println(std.num);
		System.out.println(std.name);
		System.out.println(std.kor);
	}
}

