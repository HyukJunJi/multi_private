package day06;
//has a : 속성 2개~3개
//메서드 :3개;
public class TV {
	private int size=0;
	private int prize=0;
	private String company="";
	private String purchase="";
	private boolean state;
	private int channel;
	
	static String wifi="KT";
	TV(){
		size=20;
		prize=100000;
		company="LG";
		purchase="용산";
	}
	TV(int s,int pr,String c,String pu){
		size=s;
		prize=pr;
		company=c;
		purchase=pu;
	}
	public void turnon() {
		System.out.println(company+"티비를 켭니다.");
		state=true;
	}
	public void turnoff() {
		System.out.println(company+"티비를 끕니다.");
		state=false;
	}
	public void change(int ch) {
		System.out.println(company+"티비 채널을 바꿉니다..");
		channel = ch;
	}
	public String toString() {
		return "사이즈:"+size+"가격:"+prize+"회사:"+company+"구매처:"+purchase+"전원:"+state+"채널:"+channel+wifi;
	}
}
