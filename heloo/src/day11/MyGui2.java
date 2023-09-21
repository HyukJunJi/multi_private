package day11;

import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyGui2 extends JFrame{
	Container cp;
	JPanel p1,p2;
//	JButton b1,b2,b3;
	Choice ch;
	String [] color = {"Red","Green","Blue","Magenta","Yellow","Cyan"};
	Canvas can;
	public MyGui2() {
		// TODO Auto-generated constructor stub
		super("::MyGui2::");
		cp=this.getContentPane();
		p1=new JPanel();
		p2=new JPanel();
		cp.add(p1,"Center");
		cp.add(p2,"North");
		
		can=new Canvas();
		p1.add(can);
		can.setSize(200,200);
		can.setBackground(Color.gray);
		
		ch=new Choice();
		p2.add(ch);
		
		for(String cr:color) {
			ch.add(cr);
			
		}
		MyHandler handler = new MyHandler(this);
		ch.addItemListener(handler);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyGui2();
	}

}
