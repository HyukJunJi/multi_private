package day04;
import java.util.*;

public class WhileTest {

	public static void main(String[] args) {
		/*  변수 선언 및 초기화식
		 *   while(조건식){
		 *   	실행문;
		 *   	증감식
		 *   }
		 * 조건식이 true이면 계속 반복 실행
		 * 
		 * */
		
		int data=0;
		while(data<10) {
			System.out.println("오전 시간입니다 "+data);
			data++;
		}
		System.out.println("The End~~~"+data);
		
		for(int data2=0;data2<10;data2++) {
			System.out.println("오후 시간이에요 "+data2);
		}
		System.out.println("Bye Bye ~~");
		
		data=7;
		while(data>0) {
			System.out.println("저녁 시간이네요^^ "+data);
			data-=3;//감소식
		}
		
		System.out.println("Good night ~ "+data);
		
	
		//무한루프 		
//		while(true) { 
//			  System.out.println("###"); 
//		}
		 
		
	
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.게임 진행 2. 종료");
			int menu=sc.nextInt();
			if(menu==2) break; //가장 가까운 반복문을 이탈함
			System.out.println("~~~게임 게임 ~~~~~");
		}//while
		System.out.println("잘가세요~~~ 또 오세요~~");
		
		
	}

}






