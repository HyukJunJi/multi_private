package day12;
import java.net.*;
import java.io.*;
/*
 * 클라이언트
 * - Socket객체 필요
 * - 서버의 IP주소, Port 번호 필요
 */
public class MyNetClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		192.168.10.82
		Socket sock=new Socket("192.168.31.106",5555);
		//서버와 연결되면 Socket객체가 생성되고,
		//연결 안되면 예외 발생
		System.out.println("서버와 연결됨 ....");
		InputStream is =sock.getInputStream();
		byte[] data= new byte[1024];
		
		int n=is.read(data);
//		메세지는 data 배열에 담긴다
//		n: 배열에 담은 바이트수를 반환
		String str =new String(data);
		System.out.println(str);
		
		OutputStream out=sock.getOutputStream();
		
		String sendMsg="반가워요 서버님 ~~~ Good Luck";
		
		byte[] data2 =sendMsg.getBytes();
		
		out.write(data2);
		out.flush();
		
		is.close();
		sock.close();
		
	
	}

}
