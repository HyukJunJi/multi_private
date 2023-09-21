package day08;

public class Superman {
	String name;
	int height;
	int power;
	public Superman() {
//		name="슈퍼맨";
//		height=150;
//		power=50;
		this("asdds",1,2);
	}
	public Superman(String name,int height,int power) {
		this.name=name;
		this.height=height;
		this.power=power;
	}
	public Superman(String name) {
		this(name,160);
	}
	public Superman(String name,int height) {
		this(name,height,200);
	}
	public String showInfo() {
		String str ="-----슈퍼맨 정보------\n";
		str+="이름:"+name+"\n키:"+height+"\n초능력:"+power;
		return str;
	}

}
