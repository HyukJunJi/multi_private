package day13;

import java.net.*;
import java.io.*;

/* -서버에 접속한다-Socket(ip,port)
 * -서버에 메시지를 보낸다.
 * -서버가 보내오는 메시지를 듣는다. =>스레드로 처리 (Runnable 상속)
 * */
public class CLIChatClient implements Runnable {
	private Socket sock;

	BufferedReader in, key;
	PrintWriter out;

	final int port = 7777;

	public CLIChatClient() {
		// TODO Auto-generated constructor stub
		// 1.Socket 생성 -ip,port
		try {
			System.out.println("###서버와 연결됨 ####");
			sock = new Socket("127.0.0.1", port);
			// 2.키보드 입력 스트림
			key = new BufferedReader(new InputStreamReader(System.in));
			// 3. 서버에 출력하기 스트림
			out = new PrintWriter(sock.getOutputStream(), true);
			// 4.서버에 메세지를 들을 스트림
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			// 5.스레드 동작=>서버가 보내오는 메세지를 리스닝하여 콘솔에 출력
			//Runnable 객체 먼저 생성
			//this가 Runnable 객체
			
			//Thread 생성 => 러너블 객체를 인자로
			Thread listener  =new Thread(this);
			//스레드 start
			listener.start();

			String msg = "";
			while ((msg = key.readLine()) != null) {
				out.println(msg);
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			close();
		}

		// 6.키보드 입력하여 서버에게 메세지를 보낸다.
	}

	private void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String sMsg = "";
			while ((sMsg = in.readLine()) != null) {
				System.out.println("From Sever>>" + sMsg);
			}
		} catch (Exception e) {
			System.out.println("Client run()" + e);
		} finally {
			close();
		}
		// 서버가 보내오는 메세지를 계속 듣고 콘솔에 출력하다.
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

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CLIChatClient();
	}

}
