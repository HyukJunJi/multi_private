package delivery;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/*
 * @author: 지혁준
 * @version:0.1
 * @since:2023.09.24
 * 프로젝트명: 소켓통신을 활용한 배달앱 사용자와 요식업 판매자에 글 게시와 주문 프로그램
 * 클래스명 : Client (사용자)
 * 내용: 사용자
 */
public class Client extends JFrame implements Runnable {
	private boolean flag;
	private BufferedReader in;
	private PrintWriter out;
	private JTextField tfId;
	private JPasswordField tfPw;
	private JScrollPane scrollPane;
	private JPanel productContainerPanel;
	private JCheckBox itemCheck;

	/*
	 * 체크 박스를 생성하는 run()에서의 코드는 체크박스가 하나만 생성됨으로 리스트를 만들어서 여러개로 구분하는 효과를 냄
	 */
	private ArrayList<JCheckBox> checkBoxList = new ArrayList<>();

	/*
	 * 사용자가 판매자로 부터 받은 데이터를 정리하기 위한 리스트
	 */
	private ArrayList<ClientShopItem> list = new ArrayList<>();

	/*
	 * clientID 사용자 정보를 보관하여 로그인시 사용하는 리스트
	 */
	private ArrayList<ClientID> clientId = new ArrayList<>();
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private CardLayout card;

	private Socket sock;
	private String host = "localhost";
	private int port = 1000;

	private String loginId;
	private boolean isLogin = false;

	public Client() {
		clientId.add(new ClientID("pong", "123"));
		clientId.add(new ClientID("admin", "tiger"));
		clientId.add(new ClientID("ji", "123"));
		System.out.println(clientId);
		for (ClientID l : clientId) {
			System.out.println("사용가능 ID:" + l.getName() + " , 비번:" + l.getPw());
		}
		this.setSize(500, 700);
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(card = new CardLayout(0, 0));

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

		/*
		 * 로그인을 위한 addActionListener
		 */
		btLogin.addActionListener(e -> {

			String id = tfId.getText();
			char[] ch = tfPw.getPassword();
			String pw = new String(ch);
			if (id == null || id == "" || id.trim().isEmpty()) {
				JOptionPane.showMessageDialog(panel, "ID 입력하세요");
				tfId.requestFocus();
			} else if (pw == null || pw == "" || pw.trim().isEmpty()) {
				JOptionPane.showMessageDialog(panel, "비밀번호 입력하세요");
				tfPw.requestFocus();
			}
			boolean isLogin = loginCheck(id, pw);
			if (isLogin) {
				this.loginId = id;
				this.isLogin = isLogin;
				setTitle(loginId + "님 로그인중");
				connectShop();
				card.show(panel, "deliveryP");
				JOptionPane.showMessageDialog(panel, "로그인 완료");
			} else {
				JOptionPane.showMessageDialog(panel, "로그인 실패");
			}

		});

		btLogin.setForeground(Color.YELLOW);
		btLogin.setBackground(Color.DARK_GRAY);
		btLogin.setFont(new Font("Serif", Font.BOLD, 24));
		btLogin.setBounds(123, 403, 235, 61);
		panel_1.add(btLogin);

		tfId.setBorder(new TitledBorder("Id"));
		tfId.setFont(new Font("sans-serif", Font.BOLD, 20));
		tfPw.setBorder(new TitledBorder("Password"));
		tfPw.setFont(new Font("sans-serif", Font.BOLD, 20));

		JButton btLogout = new JButton("Logout");
		btLogout.setForeground(new Color(255, 255, 0));
		btLogout.setBackground(new Color(30, 144, 255));
		btLogout.setFont(new Font("Serif", Font.BOLD, 26));
		btLogout.setBounds(26, 603, 425, 50);
		panel_2.add(btLogout);

		/*
		 * 로그아웃을 위한 addActionListener
		 */
		btLogout.addActionListener(e -> {
			out.println("퇴장");
			this.isLogin = false;
			this.loginId = "";
			setTitle("delivery");
			card.show(panel, "loginP");// 로그인 패널 보여주기
			tfId.setText("");
			tfPw.setText("");
			tfId.requestFocus();

			try {
				flag = true;
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (sock != null)
					sock.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
		JButton btPurchase = new JButton("Purchase");
		btPurchase.setForeground(new Color(255, 255, 0));
		btPurchase.setBackground(new Color(30, 144, 255));
		btPurchase.setFont(new Font("Serif", Font.BOLD, 26));
		btPurchase.setBounds(26, 530, 425, 50);
		panel_2.add(btPurchase);

		/*
		 * 구매를 위한 addActionListener run()에서 만든 체크박스를 체크박스 리스트에 add 한뒤에 btPurchase를 누르면
		 * 눌린 버튼을 리스트를 돌면서 확인한뒤 체크된 목록을 판매자에게 보냄
		 */
		btPurchase.addActionListener(e -> {
			for (JCheckBox l : checkBoxList) {

				if (l.isSelected()) {

					for (ClientShopItem a : list) {

						if (l.getText().equals(a.getNum())) {

							a.setClient(this.loginId);
							out.println(a);
						}
					}

				}

			}
		});
	}

	/*
	 * 소켓 연결을 통해 판매자와 소통하기 위한 메소드
	 */
	public void connectShop() {
		try {

			sock = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true);
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

	/*
	 * 사용자가 존재하는지 여부를 확인하는 메소드
	 */
	public boolean loginCheck(String id, String pw) {

		for (ClientID l : clientId) {
			if (l.getName().equals(id) && l.getPw().equals(pw)) {
				return true;
			}

		}

		return false;
	}

	/*
	 * run()메소드 판매자가 서버로 보내는 메세지를 받아서 화면에 띄움
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String serverMsg = "";
		try {
			while (!flag) {
				serverMsg = in.readLine();

				if (serverMsg == null)
					return;
				if (serverMsg.contains("Shopitem")) {

					/*
					 * 판매자에게 받은 메세지를 관리하기 위해 list에 넣는다.
					 */
					list.add(new ClientShopItem(serverMsg));
					if (list.size() > 0) {

						/*
						 * 최근에 판매자에게 받은 메세지를 가져온다.
						 */
						ClientShopItem lastItem = list.get(list.size() - 1);

						/*
						 * scrollpane에 값을 띄우기위해productPanel()을 생성
						 */
						JPanel productPanel = new JPanel();
						productPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
						ImageIcon imageIcon = new ImageIcon(lastItem.getImage());

						/*
						 * 이미지 아이콘 크기 조절
						 */
						Image image = imageIcon.getImage();
						Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

						ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

						itemCheck = new JCheckBox(lastItem.getNum());
						itemCheck.setAlignmentX(Component.LEFT_ALIGNMENT);
						productPanel.add(itemCheck);
						checkBoxList.add(itemCheck);

						JLabel imageLabel = new JLabel(scaledImageIcon);
						productPanel.add(imageLabel);

						JLabel nameLabel = new JLabel(lastItem.getName());
						nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
						productPanel.add(nameLabel);

						JLabel priceLabel = new JLabel(lastItem.getPrice());
						priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
						productPanel.add(priceLabel);

						productContainerPanel.add(productPanel);

						productContainerPanel.revalidate();

					}
				}
			}
		} catch (Exception e) {
			System.out.println("연결 끊김");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client cl = new Client();
		cl.setVisible(true);

	}

}
