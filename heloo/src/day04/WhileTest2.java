package day04;
import java.util.*;
public class WhileTest2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("구구단 몇단을 할까요?");
		int dan=sc.nextInt();
		
		//[1] while문을 이용해서 해당하는 구구단 식을 출력하세요
		int i=1;
		while(i<10) {
			System.out.printf("%d x %d = %2d%n", dan, i, dan*i);
			i++;
		}
		
		
		
		//[2] while문을 중첩하여 구구단 전체를 테이블형태로 출력하세요
		/*
		 * 2x1=2	3x1=3	4x1=4		.....	9x1=9
		 * 2x2=4	3x2=6 .....
		 * 
		 * 2x9=18	3x9=27
		 * */
		
		System.out.println("-------------------------");
		int j=1;
		
		while(j<10) {//행의 조건
			int k=2;
			while(k<10) {//열의 조건
				System.out.printf("%dx%d=%2d\t", k, j, k*j);
				k++;
			}//while			
			j++;
			System.out.println();
		}
		System.out.println("The End~~~~");

		sc.close();
	}

}




















