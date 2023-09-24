package delivery;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/*
 * @author: 지혁준
 * @version:0.1
 * @since:2023.09.24
 * 프로젝트명: 소켓통신을 활용한 배달앱 사용자와 요식업 판매자에 글 게시와 주문 프로그램
 * 클래스명 : Server
 * 내용: 서버
 */
public class Server extends Thread{
	private ServerSocket server;

	private final int port= 1000;
	
	ArrayList<UserHandler> userList = new ArrayList<>();
	/*
	 * Server()
	 * 생성시 ServerSocket 생성
	 * 
	 */
	public Server() {
		// TODO Auto-generated constructor stub
		try {
			server = new ServerSocket(port);
			System.out.println("##사용자 연결 실행중");
			System.out.println("port : "+port);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("서버 에러");
		}
		
	}
	/*
	 * run()
	 * while문을 돌면서 사용자와 판매자가 접속하는것을 기다림
	 */
	public void run() {
		System.out.println("ready....");
		while(true) {
			try {
				Socket sock = server.accept();
				System.out.println("["+sock.getInetAddress()+"]사용자님이 접속");
				System.out.println(sock.getPort());
				UserHandler userHandler = new UserHandler(sock,userList);
				userList.add(userHandler);
				userHandler.start();
				
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server shop = new Server();
		shop.start();
	}

}
