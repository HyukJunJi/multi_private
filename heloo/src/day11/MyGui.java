package day11;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//이벤트 소스: JButton, JTextField, JTextArea, JRadioButton, JCheckbox
//이벤트: ActionEvent, KeyEvent, ItemEvent
//이벤트 핸들러:
//ActionListener
//KeyListener
//ItemListener 
//=> XXXListener인터페이스를 상속받아야 함
//***************************************
/*이벤트 처리 절차
 * [1] import java.awt.event.*;
 * [2] XXXListener 인터페이스를 상속받는다 (ActionListener)
 * [3] 추상메서드를 오버라이딩한다. (빈블럭으로) => 이벤트 처리 메서드
 * [4] 이벤트소스에 리스너를 붙인다. addXXXListener()메서드 이용
 * 		=> b1.addActionListener(핸들러객체)
 * [5] 오버라이딩한 메서드에 이벤트 처리코드를 구현
 * **************************************
 * */

public class MyGui extends JFrame implements ActionListener{
	Container cp;
	JPanel p1,p2;
	JButton b1,b2,b3;
	Canvas can;
	public MyGui() {
	    this.setTitle("GUI");

	    cp = this.getContentPane();

	    p1 = new JPanel();
	    p2 = new JPanel();

	    cp.add(p1, "Center");
	    cp.add(p2, "North");
	    p2.setBackground(Color.cyan);
	    p1.setBackground(Color.WHITE);

	    p2.add(b1 = new JButton("Red"));
	    p2.add(b2 = new JButton("Green")); // Create b2 button
	    p2.add(b3 = new JButton("Blue")); // Create b3 button

	    p1.setLayout(null);

	    can = new Canvas();
	    can.setSize(200, 200);
	    can.setLocation(150, 90);
	    can.setBackground(new Color(120, 80, 200));
	    p1.add(can);

	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    this.setSize(500, 500);
	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		can.setBackground(Color.yellow);
		Object obj = e.getSource();
		if(obj==b1) {
			can.setBackground(Color.red);
		}else if(obj==b2) {
			can.setBackground(Color.green);
		}else if(obj==b3) {
			can.setBackground(Color.blue);
		}
	}
	public static void main(String[] args) {
		
		new MyGui();
	}
	
	

}
