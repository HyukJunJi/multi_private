package day04;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGame {
	
	private static JTextField tf;
	static JLabel lb = new JLabel("결과");
	static int count=0;//게임시도 횟수
	
	public static void main(String[] args) {
		//컴퓨터가 0<= num <100 사이의 임의의 정수를 발생시킨다.
		Random ran=new Random();
		int num=ran.nextInt(100);//컴퓨터값
		//System.out.println(num);
		
		
		
		
		JFrame f=new JFrame(":::숫자 맞추기 게임  v1.1:::");
		//f.setSize(500,700);//w,h
		//f.setLocation(1200,200);//x,y
		f.setBounds(1200,200,500,700);//x,y,w,h
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		f.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("0~100사이의 숫자를 맞춰보세요");
		lblNewLabel.setFont(new Font("휴먼매직체", Font.BOLD, 30));
		lblNewLabel.setBounds(24, 27, 430, 116);
		panel.add(lblNewLabel);
		
		JLabel lbCnt = new JLabel("게임시도 횟수:");
		lbCnt.setFont(new Font("휴먼매직체", Font.BOLD, 30));
		lbCnt.setBounds(34, 505, 430, 116);
		panel.add(lbCnt);
		ImageIcon iconOk=new ImageIcon("src/day04/ok_sm.png");
		ImageIcon iconNo=new ImageIcon("src/day04/no_sm.png");
		
		tf = new JTextField();
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//f.setTitle("이벤트 처리됨");
				//tf에 입력한 값 받아오기 getText()
				String input=tf.getText();
				f.setTitle(input);
				//int myAnswer=Integer.parseInt(input);
				int myAnswer=Integer.valueOf(input);
				count++;
				if(myAnswer==num) {
					lb.setText(input+": 정답!!!");
					lb.setIcon(iconOk);
				}else {
					String hint=(num > myAnswer)?"Higher":"Lower";
					
					lb.setText(input+": 오답 "+hint);
					lb.setIcon(iconNo);
					tf.setText("");
				}
				//컴퓨터가 발생시킨 값과 비교하여 그 결과를 lb와 lbCnt에 출력하기
				lbCnt.setText("게임 시도 횟수: "+count+"번");
				
			}
		});
		tf.setFont(new Font("굴림", Font.BOLD, 30));
		tf.setBounds(34, 161, 420, 123);
		panel.add(tf);
		tf.setColumns(10);
		
		
		lb.setFont(new Font("굴림", Font.BOLD, 30));
		lb.setIcon(new ImageIcon(NumberGame.class.getResource("/day04/question2.png")));
		lb.setBounds(46, 316, 406, 179);
		panel.add(lb);
		f.setVisible(true);

	}
}
