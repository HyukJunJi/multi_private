package day06;

public class Exam02 {

	public static void main(String[] args) {
		String[] 과목명= {"국어","영어","수학","컴퓨터","회화"};
		int 학기1 [] = {44,66,22,99,100};
		
		int 학기2 [] = 학기1.clone();
		
		학기2[0]=22;//국어
		학기2[2]=88;//수학
		학기2[1]=95;//영어
		System.out.println("---1학기-------");
		for(int i=0;i<학기1.length;i++) {
			System.out.println(과목명[i]+": "+학기1[i]);
		}
		
		System.out.println("---2학기-------");
		for(int i=0;i<학기2.length;i++) {
			System.out.println(과목명[i]+": "+학기2[i]);
		}
		
		int count=0;
		int count2=0;
		int index=0;
		String str="";
		for(int i=0;i<학기1.length;i++) {
			int score1=학기1[i];
			int score2=학기2[i];
			
			if(score1==score2) {
				count++;
			}else if(score2 > score1) {//오른 경우
				count2++;
				index=i;
				str+=i+",";//문자열에 인덱스 번호를 누적시킨다. 이때 구분자(,)를 이용
			}
		}//for------
		
		
		System.out.println(str);
		//String클래스의 메서드
		//String[] split(String 구분자)
		String[] token=str.split(",");
		System.out.println(token.length);
		System.out.println("token[0]="+token[0]);
		System.out.println("token[1]="+token[1]);
		
		System.out.println("성적이 변동 없는 과목수: "+count+"개");
		System.out.println("2학기에 오른 과목수: "+count2+"개");
		System.out.print("2학기에 오른 과목명: ");
		for(String idxStr:token) {
			int idx=Integer.parseInt(idxStr);
			System.out.print(과목명[idx]+", ");
		}
		System.out.println();
		
		
	}

}









