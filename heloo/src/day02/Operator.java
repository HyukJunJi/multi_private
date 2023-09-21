package day02;

public class Operator {
	
	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		Operator.print("---연산자-------");
		print("--1. 산술연산자-----");
		//+,-,*,/,%
		int a=5;
		int b=2;
		System.out.println(a/b);//몫
		//js인 경우: 2.5
		//java의 경우: int/int=>int
		System.out.println(a%b);//나머지값
		
		int x=50;
		long y=2;
		//int z=x*y;//[x]
		//int * long ==> long 큰 자료형으로 자동 형변환
		long z=x*y;
		double k=x*y;
		System.out.println(z);
		System.out.println(k);
		
		print("--2.증감연산자 (++, --)---");
		int c=8;
		int d=5;
		
		c++; //c=c+1;
		print("c: "+c);//9
		++c;
		print("c: "+c);//10
		--d;//4
		print("d: "+d);
		d--;
		print("d: "+d);
		
		float e=5.6f;
		double f=8.5f;
		System.out.println(++e);//6.6
		System.out.println(e++);//6.6
		//7.6
		System.out.println("e: "+e);//7.6
		
		System.out.println(--f);//
		System.out.println(f--);//
		System.out.println("f: "+f);
		
		print("--3. 논리부정 연산자(!)---");
		//! : 논리값, 논리식에만 사용된다. t=>f, f=>t
		boolean b1=false;
		print("b1: "+b1);
		print("!b1: "+ !b1);
		
		print("--4. 비교연산자 (==,!=, >,<, >=, <=)");
		/* = : 대입연산자
		 * == : 비교연산자 
		 * ===: 자바에는 없다[x]
		 * 비교연산자(==)
		 * [1] 기본자료형 : 값이 같은지를 비교함
		 * [2] 참조형 : 주소값이 같은지를 비교한다
		 * 
		 * != : 값이 서로 다른가? 다르면 true
		 * */
		int x1=7;
		float y1=7.0f;
		
		String s1="Hello"; //Literal Pool에 객체가 올라감
		String s2=new String("Hello");
		
		String s3="Hello";
		String s4=new String("Hello");
		
		String s5=s4;
		
		
		print("x1==y1: "+(x1==y1));//true  값을 비교
		print("s1==s2: "+(s1==s2));//false  주소값을 비교
		
		print("s1==s3: "+(s1==s3));//true
		//Literal영역에 동일한 값이 있는지 찾아서 같은 값이 있으면 같이 참조한다
		//	값이 없으면 새로운 객체를 생성
		
		print("s2==s4: "+(s2==s4));//false
		print("s5==s4: "+(s5==s4));//true
		
		//문자열내용 비교: String의 equals()메서드를 이용
		print("s2.equals(s4): "+(s2.equals(s4)));
		
		//!= (값이 다른가?, 주소값이 다른가?)
		print("x1 !=y1: "+(x1 != y1));
		
		print("s2!=s4: "+(s2 != s4));
	}
}

