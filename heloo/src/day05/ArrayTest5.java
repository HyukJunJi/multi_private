package day05;

public class ArrayTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2차원 배열:1)선언 2)메모리 할당 3)초기화
//		int[][]a; //1)선언
//		int[]a[];
//		int a[][];
		int a[][];
//					2)메모리 할당: 행의 크기, 옆의 크기 지정
		a=new int[3][2];
		System.out.println(a[0][0]);
		
		//			3)초기화
		a[0][0]=10;
		a[0][1]=20;
		
		a[1][0]=30;
		a[1][1]=40;
		
		a[2][0]=50;
		a[2][1]=60;
		System.out.println("행의 크기(a.length):"+a.length);
		System.out.println("열의 크기(a[i].length):"+a[0].length);
		for(int i = 0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		for(int[] b:a) {
			for(int x:b) {
				System.out.print(x+",");
			}
			System.out.println();
		}
		short[]s[]= {{-5,-7,-9},{10,11},{0}};
		for(short[]b:s) {
			for(short x:b) {
				System.out.print(x);
			}
			System.out.println();
		}
		char[][]ch= new char[3][];
		System.out.println("행의 크기:"+ch.length);
		ch[0]=new char[2];
		ch[1]=new char[4];
		ch[2]=new char[3];
		System.out.println("ch[0].length:"+ch[0].length);
		System.out.println("ch[1].length:"+ch[1].length);
		System.out.println("ch[2].length:"+ch[2].length);
		
		ch[0][0]='H';
		ch[0][1]='i';
		ch[1][0]='J';
		ch[1][1]='a';
		ch[1][2]='V';
		ch[1][3]='a';
		for(int i=0;i<ch.length;i++) {
			for(int j=0;j<ch[i].length;j++) {
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
	}

}
