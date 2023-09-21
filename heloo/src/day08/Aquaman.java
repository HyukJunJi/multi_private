package day08;

public class Aquaman {
	String name;
	int height;
	int power;
	public Aquaman() {

		this("asdds",1,2);
	}
	public Aquaman(String name,int height,int power) {
		this.name=name;
		this.height=height;
		this.power=power;
	}
	public Aquaman(String name) {
		this(name,160);
	}
	public Aquaman(String name,int height) {
		this(name,height,200);
	}
	public String showInfo() {
		String str ="-----아쿠아 정보------\n";
		str+="이름:"+name+"\n키:"+height+"\n초능력:"+power;
		return str;
	}
}
