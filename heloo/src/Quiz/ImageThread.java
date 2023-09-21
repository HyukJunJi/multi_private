package Quiz;

import javax.swing.ImageIcon;

public class ImageThread extends Thread {
	Quiz q;

	public ImageThread(Quiz q) {
		this.q = q;
	}

	public void run() {
		while (Quiz.timer != 0) {
			for (int i = 0; i < 10; i++) {
				ImageIcon icon = new ImageIcon("src/Quiz/images/T" + i + ".gif");
				q.image.setIcon(icon);

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
