package day11;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 tr1=new MyThread1();
		MyThread2 tr2=new MyThread2();
		
		tr1.start();
		tr2.start();
		
		
		
		//[2] java.lang.Runnable인터페이스를 상속받아 구현했을 경우
			// <1> Runnable 상속받은 객체를 먼저 생성한다.==> run()코드를 가지고 있음
			// <2> Thread객체를 생성하되, Thread생성자의 인자로 <1>번의 Runnable객체를 전달한다
			// <3> Thread객체의 start()를 호출한다.
		
		ClockThread r =new ClockThread();
		Thread tr3 = new Thread(r);
		tr3.start();
		System.out.println("Hello World~~ <==main 스레드가 실행중");
	}

}
