package Quiz;

import java.util.Date;

public class TimeThread extends Thread{
	Quiz q;
	public TimeThread(Quiz q) {
		this.q=q;
	}
	public void run() {
		for(int i =Quiz.timer;i>0 ;i--) {
		Date dt =new Date();
		q.day.setText(dt+" ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	}

}
