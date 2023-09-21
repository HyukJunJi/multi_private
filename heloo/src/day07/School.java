package day07;

public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st=new Student();
		System.out.println(st.getInfo());
		Student st1=new Student(2,"지혁준","진달래");
		System.out.println(st1.getInfo());
		System.out.println(Student.SchooLName);
	}

}
