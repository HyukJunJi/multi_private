package day06;

public class ArrayTest2 {

	public static void main(String[] args) {
		// 2차원배열의 경우: clone()을 사용해도 얕은 복사가 된다. 
		int [][] a= {{1,2,3},{4,5,6}};//2행3열
		int [][] b=a;//주소값 전달 => 얕은 복사
		int []c[] =a.clone();
		
		b[0][0]=100;
		//for each루프 이용해서 a에 저장된 값 출력하세요
		for(int[] v:a) {
			for(int x:v) {
				System.out.print(x+", ");
			}
			System.out.println();
		}
		System.out.println("----c----------");
		//for each루프 이용해서 c에 저장된 값 출력하세요
		for(int[] v:c) {
			for(int x: v) {
				System.out.print(x+", ");
			}
			System.out.println();
		}
		c[0][1]=200;
		System.out.println("----b------------");
		for(int[] v:b) {
			for(int x: v) {
				System.out.print(x+", ");
			}
			System.out.println();
		}
		
		//2차원 배열의 깊은 복사: System.arraycopy() 사용하여 복사
		//static void	arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		//							원본배열, 원본배열 시작위치, 목적배열, 목적배열의 시작위치, 길이
		
		int x[][]= {{1,2,3},{4,5,6}};
		int y[][]=new int[x.length][x[0].length];//x와 동일한 크기(2행,3열)의 배열 y를 선언하고 메모리 할당
		
		System.out.println("----y------------");
		for(int[] v:y) {
			for(int k:v) {
				System.out.print(k+", ");
			}
			System.out.println();
		}
		System.out.println("---깊은 카피 후 y---------");
		
		
		for(int i=0;i<y.length;i++) {
			System.arraycopy(x[i], 0, y[i], 0, y[i].length);
		}
		for(int[] v:y) {
			for(int k:v) {
				System.out.print(k+", ");
			}
			System.out.println();
		}
	
		y[0][0]=999;
		System.out.println("y[0][0]="+y[0][0]);
		System.out.println("x[0][0]="+x[0][0]);
	
	}//main
	

}//class














