package day13;

import java.net.*;
import java.io.*;
import java.util.*;
/*[구현할 내용]
 * - Client가 Server에 접속하면
 * [1] 서버로부터 먼저 "안녕하세요? 클라이언트님~~" 이란 메시지를 받는다.
 * [2] 그러면 클라이언트는 키보드 입력을 통해 메시지를 보낸다.
 * [3] 그러면 서버는 클라이언트로 부터 받은 메시지를 분석해서
 *     (1) "안녕하세요?" 또는 "하이" 란 메시지가 오면
 *         ==> "반가워요~~ 클님!!!" 이라 답변하고
 *     (2) "오늘 날짜는" 이란 메시지가 오면
 *        ==> 오늘 날짜를 알려주고
 *     (3) 그외 다른 메시지가 오면
 *        "~~~님, 어여 가!!"란 메시지를 보내자.      
 * */
public class EchoServer {
	public static void main(String[] args) {
		final int port = 7000;
		ServerSocket server = null;
		Socket sock = null;
		System.out.println("EchoServer Started...");
		try {
			server = new ServerSocket(port);
			sock = server.accept();
			System.out.println(sock.getInetAddress() + "님이 접속했습니다.");
			// 클에게 보내는 스트림
			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
			// 클이 보내오는 메세지를 듣는 스트림
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

			// 서버가 먼저 클에게 인사말을 건네자
			out.println("안녕하세요?" + sock.getInetAddress() + "님 ~~");

			// 반복문 돌면서 클이 보내오는 메세지를 듣자.

			String cMsg = "";
			while ((cMsg = in.readLine()) != null) {
				
				System.out.println("From Client>>" + cMsg);
				//클의 메세지를 분석해서 메아리 답변을 보내자.
				if(cMsg.startsWith("안녕")||cMsg.startsWith("하이")) {
					out.println("반가워요~~클님!!");
				}else if(cMsg.contains("오늘 날짜는")) {
					Date day =new Date();
					out.println(day);
				}else {
					out.println(sock.getInetAddress()+"님, 어여 가!!");
				}
			
				
			}
			if (in != null)
				in.close();
			if (sock != null)
				sock.close();
			if (server != null)
				server.close();
			if (out != null)
				out.close();

		} catch (IOException e) {
			System.out.println("서버 예외 " + e);
		}
	}
}
