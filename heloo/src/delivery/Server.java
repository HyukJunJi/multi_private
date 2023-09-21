package delivery;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import mychat.ChatHandler;

public class Server extends Thread{
	private ServerSocket server;
	private ServerSocket shopserver;
	private final int port= 1000;
	
	ArrayList<UserHandler> userList = new ArrayList<>();
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
