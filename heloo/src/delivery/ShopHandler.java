package delivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ShopHandler extends Thread {
	Socket sock;
	ArrayList<ShopHandler> shopList;
	BufferedReader in;
	PrintWriter out;
	public ShopHandler(Socket shopSocket,ArrayList<ShopHandler> shopList) {
		this.sock=shopSocket;
		this.sock = shopSocket;
		try {
            in = new BufferedReader(new InputStreamReader(shopSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	@Override
	public void run() {

	}

}
