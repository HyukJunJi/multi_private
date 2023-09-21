package day05;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		자료형
//		1. Primitive Type
//		2. Reference Type ==> new 연산자 객체 생성해서 초기화
//			- 클래스형
//			- 배열
//			- 인터페이스형
//			- 열거형
		int[] arr;//1차원
		int[][] arr2; //2차원
//
//
//
//		배열
//		-동종의 데이터만 저장 가능
//		- 고정 크기
//
//		int a[]={10,20,'A'}
//		a[0]
//		a[3] ==>[x]
//
//		[1] 선언
//		[2] 메모리할당
		arr=new int[3];
//		[3] 초기화
		arr[0]=10;
		arr[1]=15;
		arr[2]=20;
//
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
//		//1)
//		int []arr;
//		int arr[];
//
//		arr=new int[5];//2)
//		//3)
//		arr[0]=10; arr[1]=20;
//		arr[2]=30;...
		
		//1)선언+2)메모리 할당
		double b[] = new double[4];
		
		//3) 초기화
		b[0]=.147;
		b[1]=30e-2;
		b[2]=20;
		b[3]='A';
		
		System.out.println("b[0]="+b[0]);
		System.out.println("b[3]="+b[3]);
		
		System.out.println("b.length="+b.length);
		System.out.println("arr.length="+arr.length);
		char[] c= {'J','a','v',97};
		System.out.println("c.length:"+c.length);
		System.out.println(c[0]);
		System.out.println(c[3]);
		for(int i =0;i<c.length;i++) {
			System.out.print(c[i]);
		}
		System.out.println();
		for(int i =0;i<b.length;i++) {
			System.out.print(b[i]);
		}
		System.out.println();
//		for each loop문 -확장 for루프
		for(double a:b) {
			System.out.println(a);
		}
		for(char a:c) {
			System.out.println(a);
		}
		for(int x:arr) {
			System.out.println(x);
		}
		
		/*[문제1]
		 * 이름을 저장할 배열을 선언,메모리할당, 초기화 단계를 거처 생성하세요
		 * 
		 * */
		
//		[문제2] for루프문 이용해 한꺼번에 출력
//		[문제3] for  each루프문 이용해 한꺼번에 출력
		String name[];
		name= new String[5];
		name[0]="홍길동";
		name[1]="송영희";
		name[2]=new String("정미남");
		name[3]="박순희";
		name[4]=new String("장길동");
		for(int i=0;i<name.length;i++) {
			System.out.print(name[i]+" ");
		}
		System.out.println();
		System.out.println("------------------");
		for(String a:name) {
			System.out.println(a+" ");
		}
		
		
	}

}
