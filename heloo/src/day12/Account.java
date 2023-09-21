package day12;


public class Account {
	private int money=10;
	private boolean flag=false;
	public void save(int val) {
		synchronized(this){
		money+=val;
		System.out.printf("입금액 : %d,입금후 잔액: %d%n",val,money);
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag=true;
		notify();
		//wait pool에 대기중인 스레드 하나를 깨워서 runnable한 상태로 전환시킨다
		//notifyAll()=> 대기중인스레드 모두를깨움
		}
	}//-----------------------
	
	

	synchronized public void get(int val) {
		
		if(!flag) {
			try {
				wait();
				//wait()가 호출되면, 스레드는 수행권한을 포기하고 wait pool에 가서 대기한다.
				//이때 락을 반납하고 대기상태로 들어간다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
		}
		if(money-val<0) {
			System.out.printf("현금 부족!! 현재잔액:%d, 요청 금액: %d%n",money,val);
			flag=false;
			notify();
			return;
		}
		money-=val;
		System.out.printf("출금액: %d,출금후 잔액:%d%n",val,money);
		flag=false;
		notify();
	}
	

}
