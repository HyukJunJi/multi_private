package day08inheritance;

public class Superman extends Human {
	int power;
	
	public Superman(String n,int h,int p) {
		name=n;
		height=h;
		power=p;
		
		System.out.println("나 슈퍼맨");
	}
	@Override //annotation
	public void showInfo() {
		System.out.println(name+height+power);
	}
	public void showInfo(String title) {
		System.out.println(title);
		this.showInfo();
	}
}
