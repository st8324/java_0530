package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx3 {

	public static void main(String[] args) {
		int port = 5001;//1. 포트번호 지정
		
		//2. ServerSocket 생성
		try(ServerSocket serverSocekt = new ServerSocket(port);){
			while(true) {
				//3. 연결 대기 후 요청이 오면 수락
				Socket socket = serverSocekt.accept();
				//연결한 클라이언트와 읽고 쓰기를 함.
				//서버와 클라이언트의 기능이 다르면 Server 클래스를 추가해서
				//아래 부분을 Client가 아닌 Server로 수정
				Client client = new Client(socket);
				//read()/send() 순서 중요하지 않음. 어차피 스레드를 이용해서
				client.read();
				client.send();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
