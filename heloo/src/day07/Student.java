package day07;

public class Student {
	int no;
	String name;
	String className;
	
	static String SchooLName;
	static {
		SchooLName="멀티캠퍼스";
	}
	public Student() {
		no=1;
		name="홍길동";
		className="길동이반";
	}
	public Student(int no,String name,String className) {
		this.no=no;
		this.name=name;
		this.className=className;
	}
	public String getInfo() {
		return no+name+className;
	}
}
