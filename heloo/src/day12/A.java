package day12;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class A extends Thread {
	MyAnimation a;// null
	static boolean isStop = false;

	public A(MyAnimation a) {
		this.a = a;
	}

	@Override
	public void run() {

		synchronized (a.lbImage) {
			// TODO Auto-generated method stub
//		if a.btStart

			for (int i = 0; !isStop; i++) {
				if (i > 9) {
					i = 0;
				}
				ImageIcon icon = new ImageIcon("src/day12/images/T" + i + ".gif");
				a.lbImage.setIcon(icon);
			
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("예회:" + e);
				}
			} // for--0
		} // sync

	}
}
