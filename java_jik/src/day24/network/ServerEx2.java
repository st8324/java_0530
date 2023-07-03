package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx2 {

	public static void main(String[] args) {
		int port = 5001;//1. 포트번호 지정
		
		//2. ServerSocket 생성
		try(ServerSocket serverSocekt = new ServerSocket(port);){
			while(true) {
				//3. 연결 대기 후 요청이 오면 수락
				Socket socket = serverSocekt.accept();
				//4. 작업
				//4-1. 서버에서 클라이언트로 전송하는 스레드 생성 및 실행
				Thread sendThread = new Thread(()->{
					Scanner sc = new Scanner(System.in);
					
					try{
						//서버에서 클라이언트로 전송하는 작업을 무한히 반복. socket 연결이 끊길때까지
						//=> 클라이언트가 접속 종료를 할 때까지
						while(true){
							//콘솔에서 입력
							String str = sc.nextLine();
							//입력받은 문자열을 전송하기 위해 byte로 변환
							byte [] bytes = str.getBytes();
							OutputStream os = socket.getOutputStream();
							//변환된 byte들을 전송
							os.write(bytes);
							os.flush();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				sendThread.start();
				//4-2. 클라이언트에서 보낸 데이터를 읽어오는 스레드 생성 및 실행
				Thread readThread = new Thread(()->{
					try {
						InputStream is = socket.getInputStream();
						//데이터를 받는 작업을 무한히 반복. 클라이언트 연결이 끊길 때까지
						while(true) {
							//받아올 공간을 생성
							byte [] bytes = new byte[1024];
							//보내준 데이터를 공간에 받아옴
							is.read(bytes);
							//받아온 데이터를 문자열로 변환
							String str = new String(bytes);
							
							System.out.println("client : " + str);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				readThread.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
