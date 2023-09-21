package day09;

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person(1,"홍길동","서울");
		System.out.println(p1);
		
		Object p2 = new Person(2,"김객체","부산");
		System.out.println(p2);
		
		Student s1 = new Student(100,"이철수","서울","자바반");
		System.out.println(s1);
		
		Person s2 = new Student(101,"아아호","경기","씨반");
		System.out.println(s2);
		
		Teacher t1 = new Teacher(200,"송교사","서울","C");
		System.out.println(t1);
		
		
		Person t2 = new Teacher(201,"최교사","부천","java");
		System.out.println(t2);
		
		//p1~ t2 객체 저장할 배열 선언 메로리 할당한뒤 저장하고
		//for 루프 해서 한꺼번에 정보 출력
		//boolean instanceof 클래스명: 변수가 클래스의 객체면 true, 아니면 false반환
		Person [] arr= {p1,s1,t1,t2,(Person)p2};
		for(Person a : arr) {
			if(a instanceof Teacher) {
			System.out.println(((Teacher)a).toString("교사정보"));
		}else {
			System.out.println("*********");
			System.out.println(a);
		}
	}
	}
}
