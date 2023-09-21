package day12;

public class UserIn extends Thread {
	private Account account;
	
	
	public UserIn(String name,Account ac) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.account=ac;
	}
	
	public void run() {
		for(int i =0;i<5;i++) {
			account.save(1);
		}
	}

}
