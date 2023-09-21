package day02;

public class Primitive3 {
	
	public static void main(String[] args) {
		System.out.println("---문자형---------------");
		//char(2byte. 0 ~ 65535) :자바는 유니코드 체계를 사용 (모든 국가 언어 표현 가능)
		char c1='가';
		char c2='家';
		char c3='A';
		char 성='최';
		char c4='\uff57';//유니코드
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
		System.out.println("c4="+c4);
		
		//문자 유형은 연산에 사용되면 자동으로 int형으로 형변환된다
		/* char + int ==> int
		 * char * char ==> int
		 * 
		 * int보다 작은 유형의 데이터가 연산에 사용될 경우
		 * 자동으로 int유형으로 형변환 된다
		 * byte-----+
		 * short----+===> int
		 * char-----+
		 * 
		 * */
		System.out.println(c3+1);//66
		System.out.println((char)(c3+1));//'B' //강제형변환 =>downcasting
		//자료형=(자료형)값 
		//casting연산자 ()를 이용
		
		byte b1=10;
		byte b2=20;
		
		//byte b3=b2-b1; [x]
		int b3=b2-b1;//[o]
		System.out.println("b3="+b3);
		
		byte b4=(byte)128;
		System.out.println("b4="+b4);//-128
		/*   128
		 *    64 ...0
		 *    32 ...0
		 *    16 ...0
		 *     8 ...0
		 *     4 ...0
		 *     2 ...0
		 *     1 ...0
		 * 
		 * 128		: [00000000 00000000  00000000] 10000000  <=int
		 * (byte)128: 10000000 <=byte
		 * 			=>-128
		 * 			데이터 손실이 발생할 수 있다
		 * 하위 8bit만 남기고 앞을 잘라내기 함
		 * */
		short s=(short)128;
		System.out.println(s);
		
		System.out.println("---논리형---------------");
		//boolean (1byte): true, false값만 갖는다.
		boolean bool=true;
		boolean bool2=2>5;
		System.out.println("bool="+bool);
		System.out.println("bool2="+bool2);
		
		//자바의 논리형은 형변환 불가능. 0이나 1로 호환되지 않는다
		
		//int @@@=10; //변수명 특수문자 사용 불가 (_, $는 예외)
		int $$$=10;//[o]
		int my$age=22;//[o]
		int my_age=23;//[o]
		//int my&age=24;//[x]
		int nine9=9;//[o]
		//int 9nine=9; //[x]숫자로 시작 불가
		
	}//main

}//class









