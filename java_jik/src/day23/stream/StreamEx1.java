package day23.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StreamEx1 {

	public static void main(String[] args) {
		
		/* test.txt는 상대 경로. 기준은 프로젝트 폴더가 기준
		 * */ 
		/*FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("test.txt");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} finally {
			//프로그램 종료 전 사용했던 파일을 닫아줌
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		*/
		Scanner sc = new Scanner(System.in);
		//파일을 쓰는 예제
		try(FileOutputStream fos = new FileOutputStream("test.txt")){
			for(int i = 0; i<5; i++) {
				System.out.print("input : ");
				char ch = sc.next().charAt(0);
				fos.write(ch);
			}
			
		} catch (FileNotFoundException e1) {
			System.out.println("File not found!!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//파일을 읽는 예제
		try(FileInputStream fis2 = new FileInputStream("test.txt")){
			int data;
			while((data = fis2.read()) != -1 ) {
				System.out.println((char)data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(1);
		System.out.println((int)'1');
	}

}






