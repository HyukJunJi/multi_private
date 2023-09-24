package delivery;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
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
 * 내용: 소켓통신을 활용한 배달앱 사용자와 요식업 판매자에 글 게시와 주문 프로그램
 * 클래스명 : Shop (판매자)
 * 내용: 판매자
 */
public class Shop extends JFrame implements Runnable {
	private JTextField tfItemPrice;
	private JTextField tfItemName;
	private JPanel panel;
	private JButton btImageUpload;
	private JLabel lbImagePath;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private Socket shopsock;
	private BufferedReader in;
	private PrintWriter out;
	private int port = 1000;
	private boolean flag;
	private String selectedFilePath;
	private String id = "shop";
	private String host = "localhost";
	private JPanel productContainerPanel;
	private ArrayList<ShopClientItem> tmpsclist = new ArrayList<>();
	private ArrayList<ShopClientItem> sclist = new ArrayList<>();
	private ArrayList<ShopItem> list = new ArrayList<>();
	private JButton btitem;
	private ArrayList<JButton> btitemlist = new ArrayList<>();

	public Shop() {
		this.setSize(500, 700);

		panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btUpload = new JButton("올리기");
		btUpload.setBounds(26, 603, 425, 50);
		panel.add(btUpload);

		btUpload.addActionListener(e -> {
			/*
			 * 사용자에게 보내기위한 데이터
			 */
			ShopItem shopitem = new ShopItem(tfItemName.getText(), tfItemPrice.getText(), selectedFilePath);
			list.add(shopitem);
			// 서버로 내놓기
			out.println(shopitem);

			tfItemName.setText("");
			tfItemPrice.setText("");
			lbImagePath.setText("");
		});

		tfItemPrice = new JTextField();
		tfItemPrice.setBounds(26, 533, 425, 50);
		panel.add(tfItemPrice);
		tfItemPrice.setColumns(10);
		tfItemPrice.setBorder(new TitledBorder("Price"));

		tfItemName = new JTextField();
		tfItemName.setBounds(26, 470, 425, 50);
		tfItemName.setBorder(new TitledBorder("Item Name"));
		panel.add(tfItemName);
		tfItemName.setColumns(10);

		btImageUpload = new JButton("파일 열기");
		btImageUpload.setBounds(26, 420, 100, 30);
		panel.add(btImageUpload);

		/*
		 * 업로드 버튼을 누를시 fileChooser에 있던 사진과 다른 입력정보들이 사용자에게 전송
		 */
		btImageUpload.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {

				selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
				lbImagePath.setText(selectedFilePath);
			} else {

				lbImagePath.setText("");
			}
		});
		lbImagePath = new JLabel("");
		lbImagePath.setBounds(138, 420, 310, 30);
		panel.add(lbImagePath);

		lblNewLabel = new JLabel("주문 목록");
		lblNewLabel.setBounds(208, 10, 57, 15);
		panel.add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 49, 425, 363);
		panel.add(scrollPane);
		productContainerPanel = new JPanel();
		productContainerPanel.setLayout(new BoxLayout(productContainerPanel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(productContainerPanel);
		connectShop();

	}

	/*
	 * 서버에 연결을 위한 메소드
	 */
	public void connectShop() {
		try {

			shopsock = new Socket(host, port);
//			in = new BufferedReader(new InputStreamReader(sock.getInputStream())))
			in = new BufferedReader(new InputStreamReader(shopsock.getInputStream()));
			out = new PrintWriter(shopsock.getOutputStream(), true);
			out.println(id);
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
	 * run() 메소드
	 * 메세지를 한줄씩 가져오기 때문에 2개를 보내면 한개씩 두번을 보낸다
	 * 그래서 생각한 방법은 tmp를 만들어서 while문을 돌아서 하나씩 출력한뒤에 그 값을 list에 넣고 
	 * tmp를 clear하는 것이었다. 이렇게해서 보내기 버튼을 눌렀을때 특정 list에 값을 삭제할려 했는데 그 기능은 넣지 못하였다.
	 * 더 쉬운 방법이 분명 존재한다.
	 * 이렇게 한 이유는 한개에 리스트로 한다면 그 리스트에 값이 while문을 돌면서 중복으로 나오기 때문이다.
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
				if (serverMsg.contains("client")) {
					tmpsclist.add(new ShopClientItem(serverMsg));
					for (ShopClientItem l : tmpsclist) {
						sclist.add(l);

					}

					if (tmpsclist.size() > 0) {

						ShopClientItem lastItem = sclist.get(sclist.size() - 1);
						JPanel productPanel = new JPanel();
						productPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
						ImageIcon imageIcon = new ImageIcon(lastItem.getImage());

						Image image = imageIcon.getImage();
						Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

						ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

						JLabel clientLabel = new JLabel(lastItem.getClient());
						clientLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
						productPanel.add(clientLabel);

						JLabel imageLabel = new JLabel(scaledImageIcon);
						productPanel.add(imageLabel);

						JLabel nameLabel = new JLabel(lastItem.getName());
						nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
						productPanel.add(nameLabel);

						JLabel priceLabel = new JLabel(lastItem.getPrice());
						priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
						productPanel.add(priceLabel);

						btitem = new JButton("보내기" + lastItem.getNum());
						btitem.setAlignmentX(Component.LEFT_ALIGNMENT);
						btitemlist.add(btitem);
						productPanel.add(btitem);

						productContainerPanel.add(productPanel);

						productContainerPanel.revalidate();

					}

					tmpsclist.clear();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Shop sc = new Shop();
		sc.setVisible(true);
		sc.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
