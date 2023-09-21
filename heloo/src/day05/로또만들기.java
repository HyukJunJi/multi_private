package day05;

import java.util.Random;
import java.util.Scanner;

public class 로또만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Random rd= new Random(42);
		int[] lotto = new int[100];
		for(int i = 0;i<10;i++) {
			int num=rd.nextInt(45)+1;  //1<=num<46
			lotto[i]=num;
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
				}
			}
		}
		for(int i = 0;i<10;i++) {
			System.out.print(lotto[i]+" ");
		}
		int cnt=0;
		for(int a:lotto) {
			if(a>=30) {
				cnt++;
			}
		}
		System.out.println("30이상의 수:"+cnt);
//		int num=rd.nextInt(45)+1;  //1<=num<46
//		System.out.println(num);
		
	}

}
