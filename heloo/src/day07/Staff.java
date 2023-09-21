package day07;

public class Staff {
	private int no;
	private String name;
	private String dept;
	private int sal;
	public Staff() {
		no=100;
		name="이순신";
		dept="기획부";
		sal=8000;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Staff(int no,String name,String dept,int sal) {
		this.no=no;
		this.name=name;
		this.dept=dept;
		this.sal=sal;
	}
	public void printInfo() {
		System.out.println(no+name+dept+sal);
	}
}
