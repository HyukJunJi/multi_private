package day08;

public class CoffeMachine {
	int sugar;
	int coffee;
	int cream;
	public void makeTea(int c,int s,int cream) {
		coffee=c;sugar=s;
		System.out.println("밀크 커피 나가요 ~~ 농도:"+(coffee+sugar));
	}
	
	public void makeTea(int c,int s) {
		coffee=c;sugar=s;
		System.out.println("설탕 커피 나가요 ~~ 농도:"+(coffee+sugar));
	}
	public String makeTea(int c) {
		coffee=c;
		return "블랙커피 나가요~~ 농도:"+coffee;
	}
	public void makeTea(int coffee, long cream) {
		this.coffee=coffee;
		this.cream=(int)cream;
		System.out.println("크림 커피 나가요~~ 농도"+(this.coffee+this.cream));
	}
	public void makeTea(long cr,int cf) {
		this.makeTea(cf,cr);
	}
	public String makeTea(Yuja y) {
		String str="유자농도:"+y.getYuja()+"\n설탕농도:"+y.getSugar();
		str+="\n유자차 나가요~~ 농도:"+(y.getYuja()+y.getSugar());
		return str;
	}
}
