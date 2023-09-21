package day03;

import javax.swing.JButton;
import javax.swing.JFrame;

//CLI : Command Line Interface
//GUI : Graphic User Interface => Java.awt, javax.swing, javaFx
public class MyGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f =new JFrame();
		f.setSize(500,500);
		f.setVisible(true);
		JButton bt = new JButton("회원가입");//Component 옷이 단추 컴포넌트
		
		f.getContentPane().add(bt);
	}

}
