package day03;

import java.util.Scanner;

public class ifTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("이름 입력:");
		
		Scanner sc=new Scanner(System.in);
		
		String name=sc.next();
		
		System.out.println("name:"+name);
		System.out.println("생년 입력:");
		int age=sc.nextInt();
		System.out.println(age+"년에 태어났군요~");
		if(age%2==0) {
			System.out.println("짝수 년에 태어났군요");
		}else {
			System.out.println("홀수 년에 태어났군요");
		}
	}

}
