package day08inheritance;

public class Aquaman extends Human {
	double speed;
	public Aquaman() {
		name="홍길동";
		height=1000;
		speed=0.3;
	}
	public Aquaman(String n,int h,double s) {
		name=n;
		height=h;
		speed=s;
	}
	
	@Override
	public void showInfo() {
		System.out.println("a  "+name+height+speed);
	}
}
