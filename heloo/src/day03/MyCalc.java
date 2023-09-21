package day03;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyCalc {
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tfResult;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f =new JFrame("::MyCalc v1.0::");
		f.setSize(500,700);
		f.setLocation(1200,200);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		f.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(67, 61, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\multicamp\\JavaWorkspace\\캡처.PNG"));
		lblNewLabel_1.setBounds(60, 46, 357, 258);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("숫자1");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 36));
		lblNewLabel_2.setBounds(43, 348, 105, 57);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("숫자2");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 36));
		lblNewLabel_2_1.setBounds(43, 428, 105, 57);
		panel.add(lblNewLabel_2_1);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("굴림", Font.BOLD, 36));
		tf1.setBounds(182, 348, 223, 57);
		panel.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("굴림", Font.BOLD, 36));
		tf2.setColumns(10);
		tf2.setBounds(182, 428, 223, 57);
		panel.add(tf2);
		
		JButton plusbtn = new JButton("+");
		plusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = tf1.getText();
				String input2=tf2.getText();
				if(tf1 == null || tf1.equals("")) {
					showMsg("첫번째 숫자를 입력하세요.");
					return;
				}
				if(tf2 == null || tf2.equals("")) {
					showMsg("두번째 숫자를 입력하세요.");
					return;
				}
				float result  = Float.parseFloat(input)+Float.parseFloat(input2);
				tfResult.setText("결과: " + result);
			}
		});
		plusbtn.setFont(new Font("굴림", Font.BOLD, 36));
		plusbtn.setBounds(60, 507, 63, 41);
		panel.add(plusbtn);
		
		JButton divbtn = new JButton("/");
		divbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = tf1.getText();
				String input2=tf2.getText();
				if(tf1 == null || tf1.equals("")) {
					showMsg("첫번째 숫자를 입력하세요.");
					return;
				}
				if(tf2 == null || tf2.equals("")) {
					showMsg("두번째 숫자를 입력하세요.");
					return;
				}
				float result  = Float.parseFloat(input)/Float.parseFloat(input2);
				tfResult.setText("결과: " + result);
			}
		});
		divbtn.setFont(new Font("굴림", Font.BOLD, 36));
		divbtn.setBounds(349, 507, 68, 41);
		panel.add(divbtn);
		
		JButton mulbtn = new JButton("x");
		mulbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = tf1.getText();
				String input2=tf2.getText();
				if(tf1 == null || tf1.equals("")) {
					showMsg("첫번째 숫자를 입력하세요.");
					return;
				}
				if(tf2 == null || tf2.equals("")) {
					showMsg("두번째 숫자를 입력하세요.");
					return;
				}
				float result  = Float.parseFloat(input)*Float.parseFloat(input2);
				tfResult.setText("결과: " + result);
			}
		});
		mulbtn.setFont(new Font("굴림", Font.BOLD, 36));
		mulbtn.setBounds(253, 507, 63, 41);
		panel.add(mulbtn);
		
		JButton minusbtn = new JButton("-");
		minusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = tf1.getText();
				String input2=tf2.getText();
				if(tf1 == null || tf1.equals("")) {
					showMsg("첫번째 숫자를 입력하세요.");
					return;
				}
				if(tf2 == null || tf2.equals("")) {
					showMsg("두번째 숫자를 입력하세요.");
					return;
				}
				float result  = Float.parseFloat(input)-Float.parseFloat(input2);
				tfResult.setText("결과: " + result);
			}
		});
		minusbtn.setFont(new Font("굴림", Font.BOLD, 36));
		minusbtn.setBounds(150, 507, 63, 41);
		panel.add(minusbtn);
		
		tfResult = new JTextField();
		tfResult.setText("여기에 결과 출력");
		tfResult.setFont(new Font("굴림", Font.BOLD, 36));
		tfResult.setBounds(60, 578, 357, 57);
		panel.add(tfResult);
		tfResult.setColumns(10);
		f.setVisible(true);
		
	}
	public static void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
