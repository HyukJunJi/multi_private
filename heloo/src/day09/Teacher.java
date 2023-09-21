package day09;

public class Teacher extends Person {
	String subject;
	
	public Teacher(int no,String name,String addr,String subject) {
		super(no,name,addr);
		this.subject=subject;
	}

	@Override
	public String toString() {
		return "Teacher [subject=" + subject + ", no=" + no + ", name=" + name + ", addr=" + addr + "]";
	}
	//Overload
	public String toString(String title) {
		return "####"+title+"####\n"+this.toString();
	}

}
