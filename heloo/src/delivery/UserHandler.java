package delivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;



public class UserHandler extends Thread {
	Socket sock;
	ArrayList<UserHandler> userList;
	BufferedReader in;
	PrintWriter out;
	boolean isStop=false;
	public UserHandler(Socket userSocket,ArrayList<UserHandler> arr) {
		this.sock=userSocket;
		this.userList=arr;
		for(UserHandler l:userList) {
			System.out.println(l+"안녕");
		}
		try {
			
			//서버로입력
			in = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			//
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
			//모든접속자에게 입장한 사람을 쏴주자
			
			while(!isStop) {
				String cmsg=in.readLine();
				broadcast(cmsg);
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
	}
	private synchronized void broadcast(String sendMsg) {
		// TODO Auto-generated method stub
		if(userList==null) return;
		for(UserHandler chat:userList) {
			chat.out.println(sendMsg);
		}//for ------
	}
	

}
