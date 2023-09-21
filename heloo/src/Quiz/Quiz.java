package Quiz;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;





public class Quiz extends JFrame{
	JLabel count,image,day;
	Container cp;
	CountThread ct;
	ImageThread it;
	TimeThread tt;
	static Quiz q;
	static int timer=10;
	public Quiz() {
		cp = this.getContentPane();
		cp.setBackground(Color.WHITE);
		setSize(800,300);
		count = new JLabel("카운트");
		image = new JLabel("이미지");
		day =new JLabel("시각");
		
		cp.add(count,"West");
		cp.add(image,"East");
		cp.add(day,"South");
		
		Font font = new Font("나눔 고딕",Font.BOLD,50);
		count.setFont(font);
		image.setFont(font);
		day.setFont(font);
		
		ct =new CountThread(this);
		ct.start();
		it =new ImageThread(this);
		it.start();
		tt =new TimeThread(this);
		tt.start();
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		q = new Quiz();
	}
}	
