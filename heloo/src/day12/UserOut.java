package day12;

public class UserOut extends Thread {
	private Account account;
	
	public UserOut(String name,Account ac) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.account=ac;
	}
	
	public void run() {
		for(int i =0;i<5;i++) {
			int val=(int)(Math.random()*5+1);
			account.get(val);
		}
	}
	

}
