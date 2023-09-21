package day02;

public class Operator3 {

	public static void main(String[] args) {
		//Ctrl+ D : 현재 커서 라인을 삭제
		System.out.println("--삼항 연산자-------");
		/* 변수 선언문 = (조건식)? 값1: 값2;
		 * 	=> 조건식이 true이면 값1을 변수에 대입하고,
		 * 			  false이면 값2를 대입한다
		 * */
		int a=50, b=6;
		int result=(a<b)? a:b;
		System.out.println("result: "+result);
		
		String result2=(a>b)? a+"":b+"";
		System.out.println("result2: "+result2);
		
		System.out.println("--연산후 대입연산자 (+=, -=,*=,/=,%=)");
		int i=5;
		i+=5;
		System.out.println(i);//10
		i-=3;
		System.out.println(i);//7
		i/=3;
		System.out.println(i);//2
		i*=8;
		System.out.println(i);//16
		i%=5;
		System.out.println(i);//1
	}

}
