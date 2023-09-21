package day10;

import java.util.*;
/* 컬렉션:
 * List, Set , Map, //Queue
 * - ArrayList
 * 	-java.util.List계열
 * 	-입력순서를 기억한다.
 * 	-데이터 중복을 허용한다.
 * 	-동적으로 저장크기를 늘릴 수 있다.
 * 	-참조형의 데이터를 저장함.
 *  -다른 유형의 데이터도 저장 가능함
 *  
 */
public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList lst = new ArrayList();
		lst.add("홍길동");
		lst.add("이순신");
		lst.add(100); //100정수 ==>auto boxing ==>Integer 객체로 저장됨
		lst.add(Integer.valueOf(200));
		lst.add(3.14);//Double 객체로 저장
		lst.add('남');//Character객체로 저장
		lst.add(true);//Boolean객체
		Object obj =lst.get(0);
		System.out.println(obj);
		char ch=((String)obj).charAt(0);
		System.out.println(ch);
		Character c= (Character)lst.get(5);
		
		//5.0 이후부터 generic을 이용
//		ArrayList<자료형> 변수 = new ArrayList<자료형>();
		
		ArrayList<String> lst2 = new ArrayList<String>(); //default 10개 저장
		lst2.add("홍길동");
		lst2.add("최영");
		lst2.add("이순신");
		lst2.add("홍길동");
		System.out.println("lst2.size()"+lst2.size());
		
		String name=lst2.get(0);
		System.out.println(name);
		for(int i=0;i<lst2.size();i++) {
			String str=lst2.get(i);
			System.out.println(str);
		}
		System.out.println("-------------------");
		for(String str:lst2) {
			System.out.println(str);
		}
		lst2.remove(2);
		System.out.println("삭제후");
		for(String str:lst2) {
			System.out.println(str);
		}
		lst2.add(2,"김철수");
		System.out.println();
		for(String str:lst2) {
			System.out.println(str);
		}
		
		lst2.clear(); //모두삭제
		System.out.println();
		for(String str:lst2) {
			System.out.println(str);
		}
	}

}
