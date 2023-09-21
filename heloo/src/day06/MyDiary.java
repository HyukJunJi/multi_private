package day06;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;

import day07.MyDiarySubFrame;

public class MyDiary {
	String memberInfo[]= {"root","tiger123"};
	private JTextField tfId;
	private JPasswordField tfPw;

	public void createGUI() {
		MyDiarySubFrame sub=new MyDiarySubFrame();
		JFrame f =new JFrame("::나의 일기장::");
		f.setBounds(1200,200,700,800);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 128));
		f.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\multicamp\\JavaWorkspace\\heloo\\src\\day06\\diary.png"));
		lblNewLabel.setBounds(31, 10, 505, 354);
		panel.add(lblNewLabel);
		
		tfId = new JTextField();
		tfId.setBounds(122, 409, 340, 50);
		panel.add(tfId);
		tfId.setColumns(10);
		tfId.setBorder(new TitledBorder("ID"));
		
		tfPw = new JPasswordField();
		tfPw.setBounds(125, 486, 337, 50);
		tfPw.setBorder(new TitledBorder("PassWord"));
		panel.add(tfPw);
		
		JButton bt1 = new JButton("");
		bt1.setMnemonic('L');
		bt1.setIcon(new ImageIcon("C:\\multicamp\\JavaWorkspace\\heloo\\src\\day06\\L.png"));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setTitle("bt1");
				String id = tfId.getText();
				String pw = tfPw.getText();
				if(memberInfo[0].equals(id) && memberInfo[1].equals(pw)) {
					JOptionPane.showMessageDialog(f, "환영합니다 root님~~");
					
					
				}
				else {
					JOptionPane.showMessageDialog(f, "아이디가 틀리거나 비밀번호가 틀려요");
				}
				sub.createSubGui();
				f.setVisible(false);
				f.dispose();
				
				//아이디,비밀번호 얻어와서 ,memeberInfo 배열에 저장된 값과 비교
				//일치하면 환영합니다. root님~~" 메세지 다이얼로그 띄우기
				//일치아지 않으면 " 아이디가 틀리거나 비밀번호들려요"메세지 다이얼로그 띄우기
			}
		});
		bt1.setBounds(72, 561, 185, 174);
		panel.add(bt1);
		
		JButton bt2 = new JButton("");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setTitle("bt2");
				tfId.setText("");
				tfPw.setText("");
				tfId.requestFocus();
				return;
				//tfId.tfPw값 비워주기
				//tfId에 입력포커스 추가
			}
			
		});
		bt2.setMnemonic('R');
		bt2.setIcon(new ImageIcon("C:\\multicamp\\JavaWorkspace\\heloo\\src\\day06\\reset.png"));
		bt2.setBounds(307, 559, 185, 176);
		panel.add(bt2);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		MyDiary my=new MyDiary();
		my.createGUI();
	}
}
