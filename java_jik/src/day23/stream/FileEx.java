package day23.stream;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) {
		
		File file = new File("test");
		try {
			//해당 파일/폴더가 존재하지 않고, 
			//이름에 .이 들어가면(확장자가 있으면) 파일을 생성
			if(!file.exists() && file.getName().contains(".")) {
				file.createNewFile();
				System.out.println("Create File!");
			}
			//해당 파일/폴더가 존재하지 않고,
			//이름에 .이 안들어가면(확장자가 없으면) 폴더를 생성
			if(!file.exists() && !file.getName().contains(".")) {
				file.mkdir();
				System.out.println("Create Directory!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//file.delete();
		
	}

}
