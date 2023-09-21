package day10;
import java.util.*;
public class HashSetTest {
	/*Set계열
	 * - 순서를 기억하지 않음
	 * - 데이터 중복을 허용하지 않음.
	 * - 구현클래스: HashSet
	 * - 해시셋은 객체를 저장하기 전에 객체의 hashCode()를 호출해서
	 *   해시코드를 얻어낸다. 그리고 이미 저장되어 있는 객체들의 해시코드와
	 *   비교한다. 만약 동일한 해시코드가 있다면 다시 equals()메소드로
	 *   두 객체를 비교해서 true가 나오면 동일한 객체로 판단하고
	 *   중복 저장을 하지 않는다.
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set =new HashSet<>();
		//add():데이터 저장
		set.add("HTML");
		set.add("CSS");
		set.add("JavaScript");
		set.add("HTML");
		//Iterator<E> iterator()
		//Enumeration<E>	elements()
		//Iterator<E>	iterator()
		/*Enumeration<E> elements()
		 * : 벡터에 저장된 객체들을 한꺼번에 꺼내오고자 할 때 사용.
		 * Enumeration과 Iterator인터페이스는 객체들을 집합체로
		 * 관리하도록 해주는 인터페이스이다.
		 * 이들 인터페이스에서는 각각의 객체들을 한 순간에 하나씩
		 * 처리할 수 있는 메소드를 제공한다.
		 * # Enumeration의 경우**********************************
		 * 	- boolean hasMoreElements() : 논리적 커서(첫번째 요소 직전에
		 * 				위치) 이후에 요소들이 있는지 물어서 있으면true
		 * 				없으면 false를 반환
		 *  - E nextElement(): 논리적 커서를 다음 요소로 이동하고
		 *  			현재 가리키고 있는 요소를 반환한다.
		 * # Iterator의 경우**************************************
		 * 	- boolean hasNext()
		 *  - E next() 
		 * */
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String str=it.next();
			System.out.println(str);
		}
		System.out.println("--------------------------");
		
		//for each loop
		for(String str:set) {
			System.out.println(str.toUpperCase());
		}
		System.out.println(set.size()+"<=저장된 객체 수");
	}

}
