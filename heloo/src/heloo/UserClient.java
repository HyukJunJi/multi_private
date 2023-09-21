package heloo;
import java.io.*;
import java.net.Socket;
public class UserClient {
    private static final int SERVER_PORT = 1000;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 사용자로부터 이름 입력 받아 서버에 전송
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("사용자 이름: ");
            String username = userInput.readLine();
            out.println("user");
            out.println(username);

            // 서버로부터 메시지 수신 및 출력
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
