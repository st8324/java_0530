package day23.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputStreamEx {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("output1.txt")){
			int data;
			do {
				data = fis.read();
				if(data == -1) {
					break;
				}
				System.out.print(data);
			}while(true);
			System.out.println();
			System.out.println("File reader success!!");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try(
			FileInputStream fis = new FileInputStream("output2.txt");
			ObjectInputStream ois = new ObjectInputStream(fis)){
			System.out.println(ois.readLine());
			for(int i = 1; i<=10; i++) {
				System.out.println(ois.readInt());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
