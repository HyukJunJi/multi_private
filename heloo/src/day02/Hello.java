package day02;//1. 패키지 선언문
//2. import 패키지명.클래스명;
//import java.lang.System;
//java.lang=>기본패키지=>생략을 해도 자동으로 import해준다.

/*
import java.util.Date;//=>생략하면 안된다
import java.util.Random;
import java.util.Scanner;
*/
import java.util.*;

//3. 클래스 선언문
//public class 클래스명{}
//클래스명: 명사형. 대문자로 시작. camel표기
//클래스명과 파일명은 반드시 같아야 한다.(대소문자도 같아야 함)
//Hello.java
public class Hello {
	
	//main()==> 실행프로그램이 된다
	public static void main(String[] args) {
		System.out.println("Hello Java ~~");
		Date  today =new Date(); //객체 생성
		System.out.println(today);
		
		Random ran=new Random();
		int num=ran.nextInt(10);//0<= r <10 사이의 랜덤한 정수값을 발생시킨다
		System.out.println("num: "+num);
		
		System.out.println("당신의 이름 입력하세요=>");
		Scanner sc=new Scanner(System.in);
		//System.in : 표준 입력 장치와 연결되어 있다
		//System.out : 표준 출력 장치
		String name=sc.next();//문자열을 입력받는다
		System.out.println("name: "+name);
	}//main()---

}//class----------------
