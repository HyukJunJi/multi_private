package day11;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyHandler implements ItemListener{
	MyGui2 main;
	public MyHandler() {
		// TODO Auto-generated constructor stub
	}
	public MyHandler(MyGui2 main) {
		this.main=main;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Color cr =Color.gray;
		String item = main.ch.getSelectedItem();
		main.setTitle(item+"을 선택했군요");
		switch(item) {
		case "Red": cr=Color.red; break;
		case "Green": cr=Color.green; break;
		case "Blue": cr=Color.BLUE; break;
		case "Magenta": cr=Color.MAGENTA; break;
		case "Cyan": cr=Color.CYAN; break;
		
		}
		main.can.setBackground(cr);
		
	}

}
