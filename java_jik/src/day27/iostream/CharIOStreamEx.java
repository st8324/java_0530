package day27.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIOStreamEx {

	public static void main(String[] args) {
		//문자 단위로 읽어오는 예제
		try(FileReader fr = new FileReader("file.txt")){
			char buffer[] = new char[1024];
			while(fr.read(buffer) != -1) {
				System.out.print(buffer);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		} catch (IOException e) {
			System.out.println("Exception!");
		}
		//문자 단위로 쓰는 예제
		//FileWriter생성자(파일명, 이어쓰기여부) : 이어쓰기 여부가 true이면 이어서 작성
		//FileWriter생성자(파일명) : 이어쓰기 여부가 false로 설정
		try(FileWriter fw = new FileWriter("file.txt", true)){
			String str = "Hello world!\n";
			fw.write(str);
			String str2 = "Hi. Java!\n";
			fw.write(str2);
		} catch (IOException e) {
			System.out.println("Exception!");
		}
	}

}
