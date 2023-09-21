package mychat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.border.*;

public class MyChatting extends JFrame implements Runnable{
	private JTextField tfId;
	private JPasswordField tfPw;
	private JTextField tfInput;
	private String host="localhost";
	private Socket sock;
	private int port = 9999;
	private BufferedReader in;
	private PrintWriter out;
	private boolean flag1 = false;
	CardLayout card;
	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_2 = new JPanel();
	JTextArea taMsg;
	HashMap<String,String> userMap=new HashMap<>();
	
	String loginId;
	boolean isLogin=false;
	public MyChatting() {
		super("::MyChatting::");
		
		
		this.setSize(500,700);
		
		userMap.put("pong","123");
		userMap.put("hong","abc");
		userMap.put("admin","tiger");
		
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(card=new CardLayout(0, 0));
		
		
		panel_1.setBackground(Color.YELLOW);
		panel.add(panel_1, "loginP");
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MyTalk");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("휴먼아미체", Font.BOLD, 30));
		lblNewLabel.setBounds(106, 75, 219, 81);
		panel_1.add(lblNewLabel);
		
		tfId = new JTextField();
		tfId.setBounds(123, 192, 235, 70);
		panel_1.add(tfId);
		tfId.setColumns(10);
		
		tfPw = new JPasswordField();
		tfPw.setBounds(123, 299, 235, 70);
		panel_1.add(tfPw);
		
		JButton btLogin = new JButton("Login");
		btLogin.setForeground(Color.YELLOW);
		btLogin.setBackground(Color.DARK_GRAY);
		btLogin.setFont(new Font("Serif", Font.BOLD, 24));
		btLogin.setBounds(123, 403, 235, 61);
		panel_1.add(btLogin);
		

		panel_2.setBackground(SystemColor.textHighlightText);
		panel.add(panel_2, "chatP");
		panel_2.setLayout(null);
		
		taMsg = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(taMsg);
		scrollPane.setBounds(30, 30, 414, 470);
		
		panel_2.add(scrollPane);
		
		tfInput = new JTextField();
		tfInput.setBounds(26, 515, 425, 63);
		panel_2.add(tfInput);
		tfInput.setColumns(10);
		
		JButton btLogout = new JButton("Logout");
		btLogout.setForeground(new Color(255, 255, 0));
		btLogout.setBackground(new Color(30, 144, 255));
		btLogout.setFont(new Font("Serif", Font.BOLD, 26));
		btLogout.setBounds(26, 603, 425, 50);
		panel_2.add(btLogout);
		
		tfId.setBorder(new TitledBorder("Id"));
		tfId.setFont(new Font("sans-serif",Font.BOLD,20));
		tfPw.setBorder(new TitledBorder("Password"));
		tfPw.setFont(new Font("sans-serif",Font.BOLD,20));
		tfInput.setBorder(new TitledBorder("Message"));
		tfInput.setFont(new Font("sans-serif",Font.BOLD,20));
		scrollPane.setBorder(new LineBorder(Color.blue, 3));
		
		taMsg.setFont(new Font("sans-serif",Font.BOLD,20));
		taMsg.setEditable(false);
		btLogin.addActionListener(e->{
			//로그인 인증을 받았다면
			String id =tfId.getText();
			char [] ch=tfPw.getPassword();
			String pw=new String(ch);
			if(id==null||id==""||id.trim().isEmpty()) {
				JOptionPane.showMessageDialog(panel, "ID 입력하세요");
				tfId.requestFocus();
			}else if(pw==null||pw==""||pw.trim().isEmpty()) {
				JOptionPane.showMessageDialog(panel, "비밀번호 입력하세요");
				tfPw.requestFocus();
			}
			try {
				boolean isLogin=loginCheck(id,pw);
				if(isLogin) {
					this.loginId=id;
					this.isLogin=isLogin;
					setTitle(loginId+"님 로그인중");
					connectChat();
					card.show(panel, "chatP");
					JOptionPane.showMessageDialog(panel, "로그인 인증에 성공했어요");
				}
				else {
					JOptionPane.showMessageDialog(panel, "로그인 인증에 실패했어요");
				}
				//챗 패널 보여주기
			}catch(NotSupportedNameException ex) {
				JOptionPane.showMessageDialog(panel, ex.getMessage());
			} 
		});
		
		btLogout.addActionListener(e->{
			out.println("##["+this.loginId+"님이 퇴장합니다]##");
			this.isLogin=false;
			this.loginId="";
			setTitle("Mychat v1.1::");
			card.show(panel, "loginP");//로그인 패널 보여주기
			tfId.setText("");
			tfPw.setText("");
			tfId.requestFocus();
			taMsg.setText("");
			try {
				flag1=true;
				if(in!=null)in.close();
				if(out!=null)out.close();
				if(sock!=null)sock.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
		
		tfInput.addActionListener(e->{
			String msg = tfInput.getText();
			//서버에 내 매세지 보내기
			out.println(msg);
			tfInput.setText("");
			
		});	
	}public void connectChat() {
		// TODO Auto-generated method stub
		try {
			sock = new Socket(host,port);
			taMsg.append("##채팅 서버와 연결됨 ...###\n");
			//소켓에 데이터를 듣는거다
			in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(),true);
			out.println(loginId);
			//서버가 보내온 메세지 듣기위해 스레드 동작
			flag1=false;
			Thread listener = new Thread(this);
			listener.start();
		} catch (Exception e) {
			// TODO: handle exception
			taMsg.append("\n채팅 서버와 연결실패");
		}
	}
	/** 생성자 */
	@Override
	/**서버가 보내오는 메세지를 듣는 taMsg에 메세지를 출력하는 스레드*/
	public void run() {
		// TODO Auto-generated method stub
		String serverMsg="";
		try {
			while(!flag1) {
				serverMsg=in.readLine();
				if(serverMsg==null) return;
				taMsg.append(serverMsg+"\n");
				taMsg.setCaretPosition(taMsg.getText().length());
				//커서의 위치를 taMsg의 끝으로 이동
			}
		} catch (Exception e) {
			// TODO: handle exception
			taMsg.append("\n서버와 연결끊김: "+e);
		}
	}
	
//	Set<String> set = h.keySet();
//	Iterator<String> it =set.iterator();
//	while(it.hasNext()) {
//		String s=it.next();
//		Integer v=h.get(s);
//		System.out.println(s+":"+v);
//	}
	Set<String> set = userMap.keySet();
	Iterator<String> it =set.iterator();
	
	/**사용자 아이디,비번을 체크하여 로그인 처리하는 메서드*/
	public boolean loginCheck(String id,String pw) throws NotSupportedNameException {
		//boolean startWith(String prefix)
		//boolean endWith(String suffix)
		if(id.startsWith("kong")||id.startsWith("콩")) {
			throw new NotSupportedNameException("콩씨는 안됩니다. 뒤질래요?");
		}
		boolean isExist =userMap.containsKey(id);
		
		if(!isExist) return false;
		
		String realPw=userMap.get(id);
		if(!realPw.equals(realPw)) return false; //비번이 일치하지 않는 경우
		
		return true;
		
//		if(userMap.containsKey(id)&&userMap.containsValue(pw)) {
//			return true;
//		}
//		else {
//			if(blackList.containsKey(id)) {
//				JOptionPane.showMessageDialog(panel, id+"씨는 절대로 입장 못합니다.");
//			}
//		}
//		return false;
	
	}
	public static void main(String[] args) {
		MyChatting my=new MyChatting();
		//my.setSize(500,700);
		my.setVisible(true);
	}
	
}
