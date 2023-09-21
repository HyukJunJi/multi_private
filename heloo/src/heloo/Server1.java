package heloo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server1 {
    private static final int USER_PORT = 1000;
    private static final int SELLER_PORT = 1001;

    private static HashMap<String, PrintWriter> userClients = new HashMap<>();
    private static HashMap<String, PrintWriter> sellerClients = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(USER_PORT);
            System.out.println("서버가 사용자 클라이언트를 대기 중입니다...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String portType = in.readLine();
                String username = in.readLine();

                if (portType.equals("user")) {
                    userClients.put(username, out);
                } else if (portType.equals("seller")) {
                    sellerClients.put(username, out);
                }

                // 클라이언트 연결을 처리할 쓰레드 시작
                ClientHandler clientHandler = new ClientHandler(clientSocket, portType, username);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private String portType;
        private String username;

        public ClientHandler(Socket socket, String portType, String username) {
            this.socket = socket;
            this.portType = portType;
            this.username = username;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;

                while ((message = in.readLine()) != null) {
                    // 메시지를 받은 후에 해당 메시지를 다른 클라이언트에게 전송
                    if (portType.equals("user")) {
                        for (PrintWriter writer : sellerClients.values()) {
                            writer.println(username + ": " + message);
                        }
                    } else if (portType.equals("seller")) {
                        for (PrintWriter writer : userClients.values()) {
                            writer.println(username + ": " + message);
                        }
                    }
                }

                // 클라이언트 연결 종료 시, 해당 클라이언트 정보를 제거
                if (portType.equals("user")) {
                    userClients.remove(username);
                } else if (portType.equals("seller")) {
                    sellerClients.remove(username);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
