package day10;
import java.util.*;
public class HashSetTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person 객체 3개 생성하기
//		HashSet 객체 생성해서 Person 3개 저장하세요
//		iterator()메세드를 이용해서 HashSet에 저장된 사람들의 이름과 나이를 출력하세요.
		Person p =new Person("홍길동",10);
		Person p1 =new Person("김영상",15);
		Person p2 =new Person("노무현",13);
		
		HashSet<Person> hs=new HashSet<>();
		hs.add(p);
		hs.add(p1);
		hs.add(p2);
		Iterator<Person> it=hs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("--------------------");
		
		Person p4=new Person("노무현",13);
		hs.add(p4);
		System.out.println("hs.size():"+hs.size());
		for(Person a:hs) {
			System.out.println(a.getName()+a.getAge());
		}
	}

}
