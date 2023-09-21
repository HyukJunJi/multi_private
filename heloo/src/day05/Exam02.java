package day05;

import java.util.Random;

public class Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] jumsu = new int[10000];
		//1만명의 수능점수를 랜덤하게 저장하세요;
		Random rd= new Random();
//		
		int num=0; //수능점수 0<=score <451;
		for(int i =0;i<jumsu.length;i++) {
			num=rd.nextInt(451);
			jumsu[i]=num;
		}
		int sum=0;
		String str="";
		int maxscorecnt=0;
		int zeroscorecnt=0;
		for(int i =0;i<jumsu.length;i++) {
			if(jumsu[i]==450) {
				str+=i+"번,";
				maxscorecnt++;
			}else if(jumsu[i]==0) {
				zeroscorecnt++;
			}
			sum+=jumsu[i];
		}
		double avg=(double)sum/jumsu.length;
		System.out.println("만점 학생수"+maxscorecnt);
		System.out.println("빵점 학생수"+zeroscorecnt);
		System.out.println("만점자 번호:"+str);
		System.out.println("평균:"+avg);
		int cnt=0;
		for(int a:jumsu) {
			
			if(a<=(avg+50) && a>=(avg-50)) {
//				System.out.println(a);
				cnt++;
			}
		}
		System.out.println("평균보다 +-점인 학생 카운트:"+cnt);
	}

}
