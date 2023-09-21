package day09;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//JDialog클래스를 상속받아 MyDialog를 구성합니다.
public class MyDialog extends JDialog{
	JLabel lb;
	Container cp;
	JButton btClose;
	ImageIcon icon,icon2;
	public MyDialog(JFrame parent,boolean modal) {
		super(parent,modal);
		
		((MyGui)parent).b1.setText("Student");
		((MyGui)parent).b1.setBackground(Color.magenta);
		cp =this.getContentPane(); //내용물을 붙이는 일종의 패널
		icon=new ImageIcon("src/day09/circle2.png");
		icon2=new ImageIcon("src/day09/ques2.png");
		
		lb=new JLabel("반갑습니다"); //디폴트 레이아웃 flow layout
		lb=new JLabel();
		lb.setIcon(icon);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.TOP);
		lb.setHorizontalAlignment(JLabel.CENTER);
		btClose=new JButton("Close");
		cp.add(lb);
		cp.add(btClose,"South");
		btClose.addActionListener(e->{
			this.setVisible(false);
			this.dispose();  //눈에 안보이게하고 메모리 수거함
		});
	}
}
