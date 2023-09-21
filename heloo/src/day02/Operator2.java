package day02;

public class Operator2 {

	public static void main(String[] args) {
		System.out.println("논리연산자( &,&&, |,||)-----");
		/* 1) &
		   2) |
		   : 앞의 연산으로 결과를 알 수 있어도 뒤의
		     문장까지 비교한다.
			
        3) &&
		   4) ||
		   : &&의 경우 앞의 연산 결과가 false라면
		     뒤의 연산을 생략한다.
			 ||의 경우는 앞의 연산결과가 true라면
			 뒤의 연산을 생략한다.
		
			 [문제1] 다음 출력 결과를 예측하세요
		*/
		int i=1;
		int j=i++;//j=1, i=2
		if((i>++j) & (i++ ==j) ) {
			i=i+j;
		}
		System.out.println("i="+i);

		
		//[2]
		int k=0;
		int p=1;
		if((k++ ==0)|(p++ ==2)) {
			k=42;
		}
		System.out.println("k="+k+", p="+p);
		
		
	}//main()

}//class
