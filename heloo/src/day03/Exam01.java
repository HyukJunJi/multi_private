
package day03;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exam01 {
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tfKor;
	private static JTextField tfMath;
	public static void main(String[] args) {
		JFrame f = new JFrame("::Exma01");
		f.setSize(700,900);
		f.setLocation(300,100);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		f.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("먹고 싶은 음식");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 78, 224, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("당신의 나이는");
		lblNewLabel_1.setBounds(66, 289, 167, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("국어점수");
		lblNewLabel_2.setBounds(77, 544, 108, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("수학점수");
		lblNewLabel_3.setBounds(92, 690, 57, 15);
		panel.add(lblNewLabel_3);
		
		tf1 = new JTextField();
		tf1.setBounds(322, 93, 116, 21);
		panel.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(322, 286, 116, 21);
		panel.add(tf2);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(333, 538, 116, 21);
		panel.add(tfKor);
		
		tfMath = new JTextField();
		tfMath.setColumns(10);
		tfMath.setBounds(343, 687, 116, 21);
		panel.add(tfMath);
		
		JButton btnNewButton = new JButton("어디로 갈까?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tf1에 입력한 값을 얻어온다.==>String getText()
				String input=tf1.getText();
//				f.setTitle("input:"+input);
				//커피==>카페로 갈께요 //아이스크림 =>베스킨라빈스로 갈께요//물을 마시세요
				if(input.equals("커피")) {
					JOptionPane.showMessageDialog(f, "카페로 갈께요");
				}else if(input.equals("베스킨라빈스")) {
					JOptionPane.showMessageDialog(f, "베스킨라빈스로 갈께요");
				}else {
					JOptionPane.showMessageDialog(f, "물을 마시세요");
				}
			}
		});
		btnNewButton.setBounds(66, 172, 438, 65);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("두 과목 점수의 평균은?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String in1 =tfKor.getText();
				String in2 =tfMath.getText();
				
				if(in1==null || in1.equals("")) {
					showMsg("국어점수를 입력하세요");
					return;
				}
				if(in2==null || in2.equals("")) {
					showMsg("수학점수를 입력하세요");
					return;
				}
				float kor = Float.parseFloat(in1);
				float math= Float.parseFloat(in2);
				float avg =(kor+math)/2;
				showMsg("평균점수:"+avg);
				
			}
		});
		btnNewButton_1.setBounds(101, 760, 438, 65);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("나의 내년 나이는?");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input= tf2.getText();
				JOptionPane.showMessageDialog(f, Integer.parseInt(input)+1);
			}
		});
		btnNewButton_2.setBounds(77, 392, 438, 65);
		panel.add(btnNewButton_2);
		
		
		
		f.setVisible(true);
		
	}
	public static void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
