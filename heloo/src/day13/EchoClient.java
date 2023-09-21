package day13;

import java.net.*;
import java.io.*;

public class EchoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String ip = "127.0.0.1";
			final int port = 7000;
			Socket sock = new Socket(ip, port);
			System.out.println("서버와 연결됨");
			// 서버 보내오는 메세지를 들을 스트림 얻기
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			// sock.getInputStream() 입력 받을게 시스템이 아니기 때문에 system.in이 아니다

			BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

			String serverMsg = in.readLine();
			System.out.println("From Server>>" + serverMsg);

			String cMsg = "";
			while ((cMsg = key.readLine()) != null) {
				out.println(cMsg);
				//서버가 보내오는 메아리를 듣자
				serverMsg=in.readLine();
				System.out.println("From Server>>"+serverMsg);
			}
			if (in != null)
				in.close();
			if (key != null)
				key.close();
			if (out != null)
				out.close();
			if (sock != null)
				sock.close();
		} catch (IOException e) {

			// TODO: handle exception
			System.out.println("클 예외:" + e);
		}
	}

}
