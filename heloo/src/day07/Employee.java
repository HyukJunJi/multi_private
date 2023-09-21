package day07;

public class Employee {
	int no;
	String name;
	String dept;
	int salary;
	public void printInfo() {
		System.out.println("---사원 정보=----");
		System.out.println(no+name+dept+salary);
	}
	public Employee() {
		no=1;
		name="아무개";
		dept="인사부";
		salary=5000;
	}
	public Employee(int no,String name,String dept,int salary) {
		this.no=no;
		this.name=name;
		this.dept=dept;
		this.salary=salary;
	}
}
