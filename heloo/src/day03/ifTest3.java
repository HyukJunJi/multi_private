package day03;

import java.util.Scanner;

public class ifTest3 {
	static String global;// 전역변수==> 디폴트값이 들어간다 null
	static int num;//0
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("국어 점수=>:");
		 float kor = sc.nextFloat();
		 System.out.println("영어 점수=>:");
		 float eng = sc.nextFloat();
		 System.out.println("------------------");
		 System.out.println("국어\t\t영어");
		 System.out.println("------------------");
		 System.out.println(kor+"\t"+eng);
		 System.out.println("------------------");
		 System.out.println("합계점수:"+kor+"\t"+eng);
		 float avg = (kor+eng)/2;
		 System.out.println("평균점수:"+avg);
		 
		 String score;
		 if(avg<=100 && avg>=90) {
			 score="A" ;
		 }else if(avg<=89 && avg>=80) {
			 score="B";
		 }else if(avg<=79 && avg>=70) {
			 score="C";
		 }else if(avg<=69 && avg>=60) {
			 score="D";
		 }else {
			 score="F";
		 }
		 
		System.out.println("학   점:"+score);
		System.out.println("------------------");
	}
}
