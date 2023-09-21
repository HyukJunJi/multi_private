package day07;

public class Teacher {
	private int no;
	private String name;
	private String subject;
	private char gender;
	public Teacher() {
		no=1;
		name="홍길동";
		subject="과목";
		gender='x';
	}
	public Teacher(int no,String name,String subject, char gender) {
		this.no=no;
		this.name=name;
		this.subject=subject;
		this.gender=gender;
	}
	public void printInfo() {
		System.out.println(no+name+subject+gender);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String toString() {
		return no+name+subject+gender;
	}
	
}
