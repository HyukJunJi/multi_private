package day08inheritance;

public class Human {
//부모 클래스 super class , base class
//	자식 클래스 sub class , derived class
	String name;
	int height;
	public Human() {
		name="나";
		height=0;
		System.out.println("나 사람");
	}
	public void showInfo() {
		System.out.println(name+height);
		
	}
	
}
