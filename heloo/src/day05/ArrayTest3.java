package day05;

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ppt55
		String travle[]=new String[5];
		travle[0]="한국";
		travle[1]="북한";
		travle[2]="일본";
		travle[3]="태국";
		travle[4]="영국";
		char color[]=new char[5];
		color[0]='y';
		color[1]='r';
		color[2]='b';
		color[3]='r';
		color[4]='p';
		double height[]=new double[5];
		height[0]=153.2;
		height[1]=165;
		height[2]=150.2;
		height[3]=176.6;
		height[4]=164.2;
		for(String a:travle) {
			System.out.println(a);
		}
		for(char a:color) {
			System.out.println(a);
		}
		for(double a:height) {
			System.out.println(a);
		}
	}

}
