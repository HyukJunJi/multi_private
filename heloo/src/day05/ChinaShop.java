package day05;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ChinaShop {
	static String[] menu= {"짜장","우동","짬뽕"};
	static int [] price= {7000,8000,5000};
	static ImageIcon[] images= {
			new ImageIcon("src/day05/짜장면.png"),
			new ImageIcon("src/day05/짜암뽕.png"),
			new ImageIcon("src/day05/우우동.png")
	};
	static int cnt=0;
	static int total=0;
	static JLabel lbimg = new JLabel("");
	static JLabel lbresult = new JLabel("총결제 금액:");
	static JLabel lbcnt = new JLabel("개수: 0개");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f =new JFrame("::홍콩반점");
		f.setSize(700,900);
		f.setLocation(1200,200);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		f.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton bt1 = new JButton("짜장면");
		bt1.setBackground(new Color(0, 255, 128));
		bt1.setFont(new Font("굴림", Font.BOLD, 20));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lbimg의 이미지 아이콘 변경하기
				lbimg.setIcon(images[0]);
				cnt++;
				total+=price[0];
				lbcnt.setText("개수:"+cnt+"개");
				lbresult.setText("총 결제 금액:"+total);
			}
		});
		bt1.setBounds(56, 28, 110, 38);
		panel.add(bt1);
		
		
		lbimg.setIcon(new ImageIcon("C:\\multicamp\\JavaWorkspace\\heloo\\src\\day05\\china.jpeg"));
		lbimg.setBounds(56, 86, 547, 415);
		panel.add(lbimg);
		
		JButton bt2 = new JButton("우동");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbimg.setIcon(images[2]);
				cnt++;
				total+=price[1];
				lbcnt.setText("개수:"+cnt+"개");
				lbresult.setText("총 결제 금액:"+total);
			}
		});
		bt2.setFont(new Font("굴림", Font.BOLD, 20));
		bt2.setBackground(new Color(0, 255, 255));
		bt2.setBounds(202, 28, 110, 38);
		panel.add(bt2);
		
		JButton bt3 = new JButton("짬뽕");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbimg.setIcon(images[1]);
				cnt++;
				total+=price[2];
				lbcnt.setText("개수:"+cnt+"개");
				lbresult.setText("총 결제 금액:"+total);
			}
		});
		bt3.setFont(new Font("굴림", Font.BOLD, 20));
		bt3.setBackground(new Color(255, 0, 255));
		bt3.setBounds(358, 28, 110, 38);
		panel.add(bt3);
		
		
		lbcnt.setFont(new Font("굴림", Font.BOLD, 18));
		lbcnt.setBounds(517, 24, 155, 49);
		
		panel.add(lbcnt);
		lbresult.setVerticalAlignment(SwingConstants.TOP);
		
		
		lbresult.setFont(new Font("굴림", Font.BOLD, 26));
		lbresult.setBounds(72, 549, 541, 247);
		
		panel.add(lbresult);
		f.setVisible(true);
	}
}
