package day07;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class MyDiarySubFrame {
	private JTextField tfDate;
	private JTextField tfTitle;
	private JTextField tfContent;
	JFrame f =new JFrame();
	public void writeFile() {
		f.setTitle("파일 저장 예정");
		try {
			String date =tfDate.getText();
			String title=tfTitle.getText();
			String content=tfContent.getText();
			
			if(date==null||date.equals("")) {
				JOptionPane.showMessageDialog(f, "날짜를 입력해야해요");
				tfDate.requestFocus();
				return;
			}
			String fileName="C:/multicamp/"+date+".txt";
			FileWriter fw = new FileWriter(fileName);
			fw.write("작성일:"+date+"\n");
			fw.write("제 목:"+title+"\n");
			fw.write("내 용:"+content+"\n");
			fw.flush();
			fw.close();
			f.setTitle(fileName+"저장완료");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			f.setTitle("파일 입출력 에러 발생:"+e1);
		}
	}
	public void readFile() {
		f.setTitle("읽어올 예정");
		try {
			
			JFileChooser jf=new JFileChooser("C:/multicamp");
			int n=jf.showOpenDialog(tfContent);
			f.setTitle("n:"+n);
			if(n==1)return; //취소시 
//			char []a= new char [10];
			File file =jf.getSelectedFile();
			String path=file.getAbsolutePath();
			FileReader fr=new FileReader(path);
			char [] data=new char[1000];
			int n1=0;
			String str="";
			while((n1=fr.read(data))!=-1) {
				String content=new String(data,0,n1);
				str+=content;
			}
			tfContent.setText(str);
			fr.close();
		} catch (FileNotFoundException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createSubGui() {
		// TODO Auto-generated method stub
				
				f.setSize(800,800);
				f.setLocation(2000,200);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 0));
				f.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				
				tfDate = new JTextField();
				tfDate.setBounds(187, 33, 302, 40);
				panel.add(tfDate);
				tfDate.setColumns(10);
				
				tfTitle = new JTextField();
				tfTitle.setBounds(185, 127, 304, 45);
				panel.add(tfTitle);
				tfTitle.setColumns(10);
				
				tfContent = new JTextField();
				tfContent.setBounds(187, 206, 328, 242);
				panel.add(tfContent);
				tfContent.setColumns(10);
				tfContent.setFont(new Font("굴림",Font.BOLD,23));
				JButton btSave = new JButton("저장");
				btSave.setBounds(162, 523, 219, 45);
				panel.add(btSave);
				
				JButton btRead = new JButton("불러오기");
				btRead.setBounds(392, 523, 208, 50);
				panel.add(btRead);
				f.setVisible(true);
				
				tfDate.setBorder(new TitledBorder("오늘날짜"));
				tfTitle.setBorder(new TitledBorder("제   목"));
				tfContent.setBorder(new TitledBorder("일기 내용"));
				
				btSave.addActionListener(e->{
					writeFile();
				});
				btRead.addActionListener(e->{
					readFile();
				});
	}
	
	public static void main(String[] args) {
		MyDiarySubFrame sub=new MyDiarySubFrame();
		sub.createSubGui();
	}
}
