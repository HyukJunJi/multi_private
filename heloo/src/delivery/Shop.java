package delivery;

import javax.swing.*;
import javax.swing.border.TitledBorder;


import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Shop extends JFrame  {
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
	private int port =1000;
	private boolean flag;
	String selectedFilePath;
	
	private String host= "localhost";
	ArrayList<ShopItem> list = new ArrayList<>();
	public Shop() {
		this.setSize(500, 700);
		
		

		panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btUpload = new JButton("올리기");
		btUpload.setBounds(26, 603, 425, 50);
		panel.add(btUpload);

		btUpload.addActionListener(e->{
			ShopItem shopitem = new ShopItem(tfItemName.getText(),tfItemPrice.getText(),selectedFilePath);
			list.add(shopitem);
			try {
				out = new PrintWriter(shopsock.getOutputStream(),true);
				System.out.println(out);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//서버로 내놓기
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
		btImageUpload.addActionListener(e->{
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
		try {
			shopsock = new Socket(host,port);
			//소켓에 데이터를 듣는거다
			//서버에서 가져오기
			in=new BufferedReader(new InputStreamReader(shopsock.getInputStream()));
			
			
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Shop sc = new Shop();
		sc.setVisible(true);
	}

	
}
