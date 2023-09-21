package day05;


import java.util.Date;
import java.util.Random;

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[]= {1,2,3,4};
		int []y;
		int []z= {100,200};
		
		y=x;
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println("z:"+z);
		
		for(int i =0;i<x.length;i++) {
			System.out.println(x[i]);
		}
		for(int a:x) {
			System.out.println(a);
		}
		y[2]=300;
		System.out.println("y[2]="+y[2]);
		System.out.println("x[2]="+x[2]);
		
		int []a= {10,20};
		int []b= {9,8,7,6};
		int tmp[];
		tmp=a;
		a=b;
		b=tmp;
		for(int n:a) {
			System.out.println("a:"+n);
		}
		for(int n:b) {
			System.out.println("b:"+n);
		}
		
		//[2] 요소 4개는 갖는 double 타입의 배열을 선언하여 초기화하세요.
		 //    그런 다음 이 배열 요소들의 평균값을 구해 출력하기
		//[3] float타입의 배열 요소를 받아들이는
		//			배열을 선언하고 크기는 3만큼 잡는다.
		//			인덱스0에는 -16.1을 넣어주고,
		//			인덱스1에는 200.1
		//			인덱스 2에는 30E-7의 값을 넣어주자.
	 	// 반복문 이용해 저장된 값을 출력하세요
		
		double db[] = {100,69.3,49,30};
		double sum=0;
		for(double bb:db) {
			sum+=bb;
		}
		System.out.println(sum/db.length);
		float fl[]=new float[3];
		
		fl[0]=-16.1f;
		fl[1]=(float)200.1;
		fl[2]=30E-7f;
		for(float ff:fl) {
			System.out.println(ff+" ");
		}
//		참조형 배열java.lang.Object ==>모든 클래스의 부모 클래스
		String[] str= {"hello",String.valueOf(10),new String("Java"), "Bye~~~",3.14+"파이"}; 
		
		Object[] obj =new Object[4];
		System.out.println(obj[0]);
//		Object유형의 배열은 모든 클래스형의 객체를 저장할 수 있다.
		obj[0] = new Object();
		obj[1] = new String("나는 문자열");
		obj[2] = new Random();
		obj[3] = new Date();
		for(int i =0;i<obj.length;i++) {
			System.out.println("obj:"+obj[i]);
		}
		System.out.println("********************");
		
		for(Object o:obj) {
			System.out.println(o);
		}
	}

}
