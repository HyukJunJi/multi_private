package day12;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;

public class MyAnimation extends JFrame implements ActionListener {
	JPanel pn, pc;
	Container cp;
	JLabel lbImage;
	JButton btStart=null, btStop=null;
	ImageIcon icon;
	A a =null;
	public MyAnimation() {
		super("::MyAnimation::");
		pn = new JPanel();
		pc = new JPanel();
		cp = this.getContentPane();
		cp.add(pn, "North");
		cp.add(pc, "Center");
		pn.setBackground(Color.pink);
		pc.setBackground(Color.lightGray);
		pn.add(btStart = new JButton("Start"));
		pn.add(btStop = new JButton("Stop"));
		icon = new ImageIcon("src/day12/images/T0.gif");// T0.gif~ T9.gif
		lbImage = new JLabel(icon);
		pc.setLayout(null);
		pc.add(lbImage);
		lbImage.setBounds(200, 80, 200, 200);
		
		
		
		btStart.addActionListener(this);
		btStop.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// 생성자-.

	public static void main(String[] args) {
		MyAnimation my = new MyAnimation();
		my.setSize(600, 600);
		my.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==btStart) {
//			if(a!=null) {
			a=new A(this);
			A.isStop=false;
			a.start();
			
		}else if(obj==btStop) {
			A.isStop=true;
//			a.stop();
			a=null;
		}
	}
}