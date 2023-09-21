package day10;
/* ArrayList는 순차적으로 데이터를 저장할 때 적합
 * LinkedList는 데이터를 저장후 수시로 객체를 삽입,수정해야 할 경우
 *            적합함
 *  LinkedList는 인접 참조를 링크해서 체인처럼 관리한다.
 *****************************************************
 *  순차적으로 추가/삭제		|	중간에 추가/삭제	|  검색	
 *  ArrayList : 빠르다.	|	느리다.			|  빠르다
 *  LinkedList: 느리다.	|   빠르다.			|   느리다.
  *****************************************************
 * */
import java.util.*;
public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1=new ArrayList<>();
		List<String> list2= new LinkedList<>();
		
		long startTime=System.nanoTime();
		for(int i =0;i<10000;i++) {
//			list1.add("hello")  순차적으로 ArrayList에 저장
			list1.add(0,"hello");//중간에 데이터를 삽입하는 경우
		}
		long endTime=System.nanoTime();
		long gap = endTime-startTime;
		System.out.println("ArrayList에 걸린 시간"+gap+"ns");
		System.out.println("list1.size():"+list1.size());
		System.out.println("************************************");
		startTime=System.nanoTime();
		for(int i=0;i<10000;i++) {
//			list1.add("hello")  순차적으로 ArrayList에 저장
			list2.add(0,"hello");//중간에 데이터를 삽입하는 경우
		}
		endTime=System.nanoTime();
		gap = endTime-startTime;
		System.out.println("ArrayList에 걸린 시간"+gap+"ns");
		System.out.println("list1.size():"+list1.size());
		System.out.println("************************************");
	}

}
