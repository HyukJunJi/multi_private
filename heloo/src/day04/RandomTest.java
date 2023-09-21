package day04;
import java.util.*;
/* 랜덤한 값 추출하는 방법
 *  [1] java.lang.Math클래스의 random()메서드 이용하는 방법
 *  	- public static double random():
 *  		0.0<= r <1.0 사이의 임의의 랜덤한 실수값을 반환하는 메서드
 *  
 *  [2] java.util.Random클래스의 nextInt(), nextFloat(), nextDouble()...이용하는 방법
 * 		- public double nextDouble()
 * 		- public int nextInt()
 * */
public class RandomTest {

	public static void main(String[] args) {
		
		double r=Math.random();
		System.out.println("r: "+r);
		//0.0<= r <1.0
		//Math.random()을 이용해서
		//		[문제1] 0<= v2 <10 사이의 임의의 정수를 발생시키세요.	
		int v2=(int)(Math.random()*10);
		System.out.println("v2: "+v2);
		
		//		[문제2] 5<= v3 <15 사이의 임의의 정수를 발생시키세요.
		int v3=(int)(Math.random()*10)+5;
		System.out.println("v3: "+v3);		
		/*
		 * int r=(int)(Math.random()*범위) +  시작수
		 * */
		
		//23<= v4 <77 사이의 임의의 정수를 구해 출력하기
		int v4=(int)(Math.random()*54)+23;
		System.out.println("v4: "+v4);	
		System.out.println("-------------------");
		
		Random ran=new Random();//ran ==>랜덤객체를 참조하는 인스턴스 변수
		double v5=ran.nextDouble();
		System.out.println("v5: "+v5);
		
		int v6=ran.nextInt();//int 값 범위의 임의의 정수값을 반환함 -2^15 ~ 2^15-1
		System.out.println("v6: "+v6);
		
		//0<= v7 <10
		//int r=ran.nextInt(범위)+시작수
		int v7=ran.nextInt(10);
		System.out.println("v7: "+v7);
		
		//23<= v8 <77 사이의 임의의 정수를 구해 출력하기
		int v8=ran.nextInt(54)+23;
		System.out.println("v8: "+v8);
		
		/*[문제] 랜덤한 알파벳 대문자를 아래와 같이 출력하세요
		 * 
		 * 		E W Q R P
				U I Z W X
				M O G H A
		 * */
		
		for(int i=0;i<3;i++) {
			for(int k=0;k<5;k++) {
				//char ch=(char)(ran.nextInt(26)+'A');
				char ch=(char)(Math.random()*26+'A');
				System.out.print(ch+"\t");
			}
			System.out.println();
		}
		
		
		
	}

}





