package day11;

public class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("증가:"+i);
		}
	}//run()----------------------------
}//////////////////////////////////////
class MyThread2 extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("증가:"+(100-i));
		}
	}
}