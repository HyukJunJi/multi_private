package Quiz;

import javax.swing.JOptionPane;

public class CountThread extends Thread {
	Quiz q;

	public CountThread(Quiz q) {
		this.q = q;
	}

	public void run() {
		while (Quiz.timer != 0) {
			q.count.setText("카운트>>" + Quiz.timer);
			Quiz.timer -= 1;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (Quiz.timer == 0) {
				JOptionPane.showMessageDialog(q, "카운트가 종료 되었습니다.");

			}
		}
	}

}
