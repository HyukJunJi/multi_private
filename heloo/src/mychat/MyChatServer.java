package mychat;

import java.net.*;
import java.io.*;
import java.util.*;
/**
 * 작성자: 지혁준
 * 작성일: 2023-09-15
 * 버전: 1.1
 *  특정 포트로 클라이언트의 연결을 무한정 기다린다.
클과  연결이  이루어지면 클라이언트와 통신을 담당할 스레드(ChatHandler)
를 생성한 후 스레드를 동작시킨다.
또한 여러 명의 클라이언트와 통신하는 ChatHandler를 ArrayList에 저장하여
관리한다.
*/
public class MyChatServer extends Thread {
	private ServerSocket server;
	private final int port=9999;
	private ArrayList<ChatHandler> userList = new ArrayList<>();
	public MyChatServer() {
		try {
			server=new ServerSocket(port);
			System.out.println("#챗 서버가 시작됐어요");
			System.out.println("##["+port+"]번 포트에서 대기 중");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("#챗버러 시작중 예외:");
		}
		// TODO Auto-generated constructor stub
	}
	public void run() {
		System.out.println("##ready...");
		while(true) {
			try {
				Socket sock = server.accept();
				System.out.println("["+sock.getInetAddress()+"[님이 접속했어요");
				ChatHandler chat = new ChatHandler(sock,userList);
				userList.add(chat);
				chat.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("클의 소켓 생성 실패에러");
			}
		}//while
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyChatServer chat = new MyChatServer();
		chat.start();
	}

}
