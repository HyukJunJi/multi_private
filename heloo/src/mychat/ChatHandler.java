package mychat;
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatHandler extends Thread {
	Socket sock;
	ArrayList<ChatHandler> userList;
	BufferedReader in;
	PrintWriter out;
	boolean isStop=false;
	public ChatHandler(Socket sock,ArrayList<ChatHandler>arr) {
		this.sock=sock;
		this.userList=arr;
		try {
			
			//서버로입력
			in = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			//내가 쓰는거
			out = new PrintWriter(sock.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e);
		}
		// TODO Auto-generated constructor stub
	}
	public void run() {
		String chatId;
		try {
			chatId = in.readLine();
			System.out.println(chatId+"님 입장함");
			//모든접속자에게 입장한 사람을 쏴주자
			String sendMsg="##["+chatId+"]님이 입장했습니다.##";
			broadcast(sendMsg);
			while(!isStop) {
				String cmsg=in.readLine();
				broadcast(chatId+">>"+cmsg);
				if(cmsg.startsWith("##[")&&cmsg.contains("퇴장")) {
					
					isStop=true;
					if(in!=null)in.close();
					if(out!=null)out.close();
					if(sock!=null)sock.close();
					userList.remove(this);
					break;
				}
			}//while--------------
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//run()----------
	/** 모든 접속자에게 메세지를 보내느 메서드*/
	private synchronized void broadcast(String sendMsg) {
		// TODO Auto-generated method stub
		if(userList==null) return;
		for(ChatHandler chat:userList) {
			chat.out.println(sendMsg);
		}//for ------
	}

}
