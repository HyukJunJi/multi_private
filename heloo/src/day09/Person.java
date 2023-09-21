package day09;

public class Person {

	int no;
	String name;
	String addr;
	
	public Person(int no,String name,String addr) {
		this.no=no;
		this.name=name;
		this.addr=addr;
	}
	@Override
	public String toString() {
		return "Person [no=" + no + ", name=" + name + ", addr=" + addr + "]";
	}
	
}
