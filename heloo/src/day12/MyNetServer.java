package day12;
import java.net.*;
import java.io.*;
/*
 * 서버단
 * - ServerSocket => 서버가 열어놓은 포트 번호 지정(0~ 65535)까지 지정가능
 * - Socket이 필요
 */
public class MyNetServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final int port=5555;
		//1. 서버 소켓 생성
		ServerSocket server = new ServerSocket(port);
		System.out.println("클라이언트 연결을 기다림...");
		//2. 무한반복 돌면서 클라이언트의 접속을 기다린다.=> accept()
		while(true) {
			Socket sock = server.accept();
			//클라이언트가 접속해서 들어오면 클라이언트와 연결된Socket을 반환함
			System.out.println("클라이언트가 접속함");
			InetAddress ip =sock.getInetAddress();
			System.out.println("클라이언트 IP:"+ip.getHostAddress());
			
			OutputStream os =sock.getOutputStream();
			//클라이언트에게 데이터를 보내느 스트림 얻어오기
			int num=(int)(Math.random()*100+1);
			String msg="From Server>>안녕하세요~ 행운의 번호를 보냅니다!!"+num;
			byte[] data=msg.getBytes();
			
			os.write(data);
			os.flush();
			
			//client가 보내오는 응답 메세지를 듣고
			//도스 콘솔에 출력해보자

			InputStream in = sock.getInputStream();
			
			byte [] data2=new byte[1024];
			
			int n = in.read(data2);
			
			String str2 = new String(data2,0,n);
			System.out.println("From Client>>"+str2);
			
			if(in!=null) in.close();
			if(os!=null) os.close();
			if(sock!=null) sock.close();
		}//while---
	}

}
