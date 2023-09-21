package day13;

import java.net.*;
import java.io.*;

/*1대 1 채팅
 * -콘솔 채팅
 * - 클라이언트 접속 기다린다.-ServerSocket, Socket
 * - 클이 보내오는 메시지를 듣는다.==> 스레드로 처리
 * - 클에게 메시지를 보낸다(키보드입력)
 * */
public class CLIChatServer extends Thread {

	private ServerSocket server;
	private Socket sock;

	BufferedReader in, key;
	PrintWriter out;

	final int port = 7777;

	public CLIChatServer() {
		// TODO Auto-generated constructor stub
		try {
			server = new ServerSocket(port);
			System.out.println("CLIChatServer Ready...");
			sock = server.accept();
			System.out.println("##클과 연결됨 ####");
//			1.키보드 입력 스트림
			key = new BufferedReader(new InputStreamReader(System.in));
			// 2.클에게 출혁할 스트림
			out = new PrintWriter(sock.getOutputStream(), true);
			// 3. 클이 보내오는 것을 듣는 스트림;
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			// 4. 스레드 종닥 =>클이 보내오는 메세지를 계속 리스닝하여 콘솔에 출력한다.
			this.start();// this-> thread를 상속 받고 있다.
			// 5. 키보드 입력하여 클에게 메세지를 보낸다.
			String msg = "";
			while ((msg = key.readLine()) != null) {
				out.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
//			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void run() {
		try {
			String cmsg="";
			while((cmsg=in.readLine())!=null) {
				System.out.println("From Client>>"+cmsg);
			}
		} catch (Exception e) {
			System.out.println("Sever run()"+e);
		} finally {
			close();
		}
	}

	public void close() {
		try {
			if (in != null)
				in.close();
			if (key != null)
				in.close();
			if (out != null)
				in.close();
			if (sock != null)
				in.close();
			if (server != null)
				in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CLIChatServer();
	}

}
