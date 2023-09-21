package day09;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyGui extends JFrame{
	JButton b1,b2,b3,b4;
	JPanel p;
	Container cp; //컴포넌트를 여기에 붙인가
	MyDialog dial;
	public MyGui() {
		super("::MyGui 프로그램 v1.1::");
		cp =this.getContentPane(); //내용물을 붙이는 일종의 패널
		
		
		p=new JPanel(); //디폴트 레이아웃 flow layout
		p.setLayout(null);
		cp.add(p,"Center");
		
		p.setBackground(Color.yellow);
		b1=new JButton("학생");
		b2=new JButton("교사");
		b3=new JButton("직원");
		b4=new JButton("종료");
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		b1.setBounds(20,30,120,50);  //x,y,w,h
		b2.setBounds(160,30,120,50);
		b3.setBounds(300,30,120,50);
		b4.setBounds(20,400,120,50);
//		JFrame f =new JFrame();
		dial =new MyDialog(this,true);
		
		
		b1.addActionListener(e->{
			
			dial.setSize(300,300);
			dial.setVisible(true);
		});
		b4.addActionListener(e->{
			System.exit(0);
		});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("MyGui");
		MyGui my = new MyGui();
		my.setSize(500,500);
		my.setVisible(true);
	}

}
