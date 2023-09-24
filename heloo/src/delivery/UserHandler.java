package delivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/*
 * @author: 지혁준
 * @version:0.1
 * @since:2023.09.24
 * 프로젝트명: 소켓통신을 활용한 배달앱 사용자와 요식업 판매자에 글 게시와 주문 프로그램
 * 클래스명 : UserHandler
 * 내용 : 서버로 유저들이 보낸 데이터를 관리하고 브로드캐스팅을 위한 클래스
 */

public class UserHandler extends Thread {
	private Socket sock;
	private ArrayList<UserHandler> userList;
	private BufferedReader in;
	private PrintWriter out;
	boolean isStop=false;
	public UserHandler(Socket userSocket,ArrayList<UserHandler> arr) {
		this.sock=userSocket;
		this.userList=arr;
		try {
			
			//서버로입력
			in = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			//서버로 출력
			out = new PrintWriter(sock.getOutputStream(),true);
        } catch (IOException e) {
            System.out.println("Error:"+e);
        }
	}
	@Override
	public void run() {
		String chatId;
		try {
			chatId = in.readLine();
			System.out.println(chatId+"님 입장함");
			//접속사 확인
			
			while(!isStop) {
				String cmsg=in.readLine();
				broadcast(cmsg);
				if(cmsg.contains("퇴장")) {
					
					isStop=true;
					if(in!=null)in.close();
					if(out!=null)out.close();
					if(sock!=null)sock.close();
					userList.remove(this);
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private synchronized void broadcast(String sendMsg) {
		// TODO Auto-generated method stub
		if(userList==null) return;
		for(UserHandler chat:userList) {
			chat.out.println(sendMsg);
		}
	}
	

}
