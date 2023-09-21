package day11;
//[2] Runnable 인터페이스를 상속받아 구현해보자
import java.util.*;
public class ClockThread implements Runnable{
	boolean isStop =false;
	@Override
	public void run(){
		// TODO Auto-generated method stub
		while(!isStop) {
			Date date=new Date();
			System.out.println(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}

	
	
}
