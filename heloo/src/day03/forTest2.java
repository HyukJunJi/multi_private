package day03;

public class forTest2 {
	public static void main(String []args) {
		//[1]for루프 이용해서 1~10까지의 합과 곱을 구해 출력하세요
				//1+2+3+....+10=55
				//1*2*3* ....*10=3628800
		//[2] 1~20까지 정수 중 2 또는 3의 배수가 아닌 수를
				//출력하고, 이 수들의 총합을 구하세요
		//[3] 알파벳 대문자A,B...Z 를 for루프 이용해 출력하기
		int sum=0;
		int mut=1;
		for(int i =1;i<=10;i++) {
			sum+=i;
			mut*=i;
			System.out.print((i<10)? i+"+":i+"="+sum);
			
		}
		System.out.println();
		System.out.println("1부터 10까지 합:"+sum);
		System.out.println("1부터 10까지 곱:"+mut);
		int sum2=0;
		System.out.print("1~20까지 정수중 2또는 3의 배수가 아닌수:");
		for(int i =1;i<=20;i++) {
			if(i%2!=0 && i%3!=0) {
				System.out.print(i+" ");
				sum2+=i;
			}
		}
		System.out.println();
		System.out.println("아닌 수들의 총합:"+sum2);
		for(int i = 0;i<=25;i++) {
			char ch=(char)(65+i);
			System.out.print(ch+" ");
		}
		System.out.println();
		for(char c='A';c<='Z';c++) {
			System.out.print(c+" ");
		}
	}
}

