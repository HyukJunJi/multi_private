package delivery;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Client extends JFrame implements Runnable {
	private boolean flag;
	private BufferedReader in;
	private PrintWriter out;
	private JTextField tfId;
	private JPasswordField tfPw;
	private JScrollPane scrollPane; 
	 private JPanel productContainerPanel; 
	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_2 = new JPanel();
	CardLayout card;
	
	private Socket sock;
	private String host= "localhost";
	private int port =1000;
	HashMap<String,String> userMap=new HashMap<>();
	String loginId;
	boolean isLogin=false;
	public Client() {
		userMap.put("pong","123");
		userMap.put("hong","abc");
		userMap.put("admin","tiger");
		this.setSize(500,700);
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(card=new CardLayout(0, 0));
		
		panel_1.setBackground(Color.YELLOW);
		panel.add(panel_1, "loginP");
		panel_1.setLayout(null);
		
		panel_2.setBackground(SystemColor.textHighlightText);
		panel.add(panel_2, "deliveryP");
		panel_2.setLayout(null);
		
		
		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(30, 30, 414, 470);
		panel_2.add(scrollPane);
		
		
		productContainerPanel = new JPanel();
        productContainerPanel.setLayout(new BoxLayout(productContainerPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(productContainerPanel);
		
		JLabel lblNewLabel = new JLabel("delivery app");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("휴먼아미체", Font.BOLD, 30));
		lblNewLabel.setBounds(130, 77, 219, 81);
		panel_1.add(lblNewLabel);
		
		tfId = new JTextField();
		tfId.setBounds(123, 192, 235, 70);
		panel_1.add(tfId);
		tfId.setColumns(10);
		
		tfPw = new JPasswordField();
		tfPw.setBounds(123, 299, 235, 70);
		panel_1.add(tfPw);
		
		JButton btLogin = new JButton("Login");
		btLogin.addActionListener(e->{
			
			String id = tfId.getText();
			char[] ch = tfPw.getPassword();
			String pw=new String(ch);
			if(id==null||id==""||id.trim().isEmpty()) {
				JOptionPane.showMessageDialog(panel, "ID 입력하세요");
				tfId.requestFocus();
			}else if(pw==null||pw==""||pw.trim().isEmpty()) {
				JOptionPane.showMessageDialog(panel, "비밀번호 입력하세요");
				tfPw.requestFocus();
			}
			boolean isLogin = loginCheck(id,pw);
			if(isLogin) {
				this.loginId=id;
				this.isLogin=isLogin;
				setTitle(loginId+"님 로그인중");
				connectShop();
				card.show(panel, "deliveryP" );
				JOptionPane.showMessageDialog(panel, "로그인 완료");
			}
			
			
		});
		btLogin.setForeground(Color.YELLOW);
		btLogin.setBackground(Color.DARK_GRAY);
		btLogin.setFont(new Font("Serif", Font.BOLD, 24));
		btLogin.setBounds(123, 403, 235, 61);
		panel_1.add(btLogin);
		
		tfId.setBorder(new TitledBorder("Id"));
		tfId.setFont(new Font("sans-serif",Font.BOLD,20));
		tfPw.setBorder(new TitledBorder("Password"));
		tfPw.setFont(new Font("sans-serif",Font.BOLD,20));
		
		JButton btLogout = new JButton("Logout");
		btLogout.setForeground(new Color(255, 255, 0));
		btLogout.setBackground(new Color(30, 144, 255));
		btLogout.setFont(new Font("Serif", Font.BOLD, 26));
		btLogout.setBounds(26, 603, 425, 50);
		panel_2.add(btLogout);
		
		JButton btPurchase = new JButton("Purchase");
		btPurchase.setForeground(new Color(255, 255, 0));
		btPurchase.setBackground(new Color(30, 144, 255));
		btPurchase.setFont(new Font("Serif", Font.BOLD, 26));
		btPurchase.setBounds(26, 530, 425, 50);
		panel_2.add(btPurchase);
	}
	public void connectShop() {
		try {
			
			sock = new Socket(host,port);
//			in = new BufferedReader(new InputStreamReader(sock.getInputStream())))
			in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(),true);
			out.println(loginId);
			flag = false;
			Thread listener = new Thread(this);
			listener.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean loginCheck(String id,String pw) {
		boolean isExist= userMap.containsKey(id);
		if(!isExist) return false;
		
		String realPw=userMap.get(id);
		if(!realPw.equals(realPw))return false;
		return true;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String serverMsg="";
		try {
			while(!flag) {
				serverMsg= in.readLine();
				System.out.println(serverMsg+"받았냐?");
				if(serverMsg==null) return;
				if(serverMsg.contains("Shopitem")) {
				System.out.println(serverMsg+"받았냐?");
				String []item=serverMsg.split("/");
				
				JPanel productPanel = new JPanel();
				productPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
				ImageIcon imageIcon = new ImageIcon(item[2]);
				
				
				JLabel imageLabel = new JLabel(imageIcon);
			    productPanel.add(imageLabel);
			   
			    JLabel nameLabel = new JLabel(item[0]);
		        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		        productPanel.add(nameLabel);
			    
		        JLabel priceLabel = new JLabel(item[1]);
		        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		        productPanel.add(priceLabel);
		     // 스크롤을 최하단으로 이동
		        productContainerPanel.add(productPanel);

		        // 패널을 다시 그리도록 요청
		        productContainerPanel.revalidate();
		        System.out.println(item[0]+item[1]+item[2]+"왜안되는데");
		        
				}
			}
		}catch(Exception e) {
			System.out.println("연결 끊김");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client cl = new Client();
		cl.setVisible(true);
		
		
	}
	
}
