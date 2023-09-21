package day04;
import java.util.*;
//1. 인기투표 프로그램 : CLI
public class SingerVote {
	
	public static void menu() { //static메서드==> class 메서드라고 함 ==> 클래스명.메서드명()
		System.out.println("--------인기투표 프로그램 v1.1--------");
		System.out.println("1)아이유  2) BTS  3) 뉴진스  4) 종료");
		System.out.println("---------------------------------");
		System.out.println("좋아하는 가수 번호를 입력하세요=>");
		System.out.println("---------------------------------");
	}//---------------------------

	public static void main(String[] args) {
		//menu()
		//SingerVote.menu();
		//SingerVote sv=new SingerVote();//[1]객체생성  객체명=>sv
		//sv.menu();//non-static메서드 ==>instance 메서드라고 함 ==> 객체명.메서드명()
		Scanner sc=new Scanner(System.in);
		
		int iu=0, bts=0, nj=0;
		int max=0;//최다 득표수
		String singer="";//최다 득표 가수명
		
		while(true) {
			menu();			
			int num=sc.nextInt();
			System.out.println(num);			
			//[1] 메뉴없는 번호 입력시 =>"입력 오류"
			if(num<1||num>4) {
				System.out.println("입력오류!! 메뉴에 있는 번호를 입력하세요(1~4)");
				//return;
				continue;
			}
			else if(num==4) {
				System.out.println(">>투표를 종료하겠습니다!!<<");
				break;
			}
			//[2] 종료 처리하기 "총 투표 결과 보여주기"
			//[3] 그 외. 누적 카운트 구하기			
			System.out.println(">>투표 진행>>>>>");
			switch(num) {
				case 1: iu++;break;
				case 2: bts++;break;
				case 3: nj++; break;
			}//switch
			if(max <iu) {
				max=iu;
				singer="아이유";
			}
			if(max <bts) {
				max=bts;
				singer="BTS";
			}
			if(max <nj) {
				max=nj;
				singer="뉴진스";
			}
			
		}//while				
		System.out.println("-------투표 결과--------------");
		System.out.printf("  1) 아이유 : %3d표\n",iu);
		System.out.printf("  2) BTS  : %3d표\n",bts);
		System.out.printf("  3) 뉴진스 : %3d표\n",nj);
		System.out.println("--------------------------");
		//최다 득표 가수: 아이유: 3표
		System.out.printf("★★최다 득표 가수: %s [%d표]★★%n",singer,max);
		System.out.println("--------------------------");
	}//main

}//class
