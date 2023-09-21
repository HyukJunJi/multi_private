package day09;
//super.변수
//super.method
//super():생성자 안에서만 호출가능. 생성자의 첫번째 라인에 위치해야함
public class Student extends Person {
//	public Student() {
//		super(); //자식 클래스의 생성자에서는 묵시적으로 super() 호출한다
//		//따라서 부모클래스에 기본 생성자가 존재해야한다.
		//만약 부모클래스에 기본생성자가 없다면, 자식 클래스는 super(인자)를 명시적을 호출해주어야 한다.
//	}
	String className;
	public Student(int no,String name,String addr,String cname) {
		super(no,name,addr);
//		this.no=no;
//		this.name=name;
//		this.addr=addr;
		className=cname;
	}
	@Override
	public String toString() {
		return "Student [className=" + className + ", no=" + no + ", name=" + name + ", addr=" + addr + "]";
	}
	
}
