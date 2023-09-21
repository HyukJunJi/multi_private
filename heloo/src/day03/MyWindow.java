package day03;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MyWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f =new JFrame();
		f.setSize(800,800);
		
		JButton btnNewButton = new JButton("North");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "까꿍");
			}
		});
		f.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("West");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=JOptionPane.showInputDialog("당신은 누구입니까?");
				if(name==null||name.equals("")) {
					f.setTitle("이름 입력해야 해요!");
					return;
				}
				f.setTitle(name+"님 입장!");
			}
		});
		f.getContentPane().add(btnNewButton_1, BorderLayout.WEST);
		
		JButton btnNewButton_2 = new JButton("East");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yn = JOptionPane.showConfirmDialog(f, "프로그램을 종료할까요?");
				f.setTitle("yn="+yn);
				if(yn==0) {
					System.exit(0);
				}
			}
		});
		f.getContentPane().add(btnNewButton_2, BorderLayout.EAST);
		
		JButton btnNewButton_3 = new JButton("South");
		f.getContentPane().add(btnNewButton_3, BorderLayout.SOUTH);
		
		JButton btnNewButton_4 = new JButton("Center");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "Welcome to Application~~");
			}
		});
		f.getContentPane().add(btnNewButton_4, BorderLayout.CENTER);
		f.setVisible(true);
	}

}
