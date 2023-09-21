package day02;

public class Primitive2 {
	
	public static void main(String[] args) {
		System.out.println("----실수형-------------");
		//float(4byte) < double (8byte) <=default
		float ft1=10.123F;
		//float의 경우 부동소수점일 경우 반드시 접미사 f를 붙여준다. 그렇지 않으면 double값으로 인식함		
		System.out.println("ft1="+ft1);
		
		float ft2=200; //promotion(자동형변환), upcasting: 작은유형에서 큰유형으로 자동으로 형변환이 일어남
		System.out.println("ft2="+ft2);//200.0
		
		float ft3='A'; //char==>float
		System.out.println("ft3="+ft3); //65.0
		
		float ft4=.856f;
		System.out.println("ft4="+ft4); //0.856
		
		//double (8byte)
		double db1=-789.258;
		double db2=4545.001d;
		System.out.println("db1="+db1);
		System.out.println("db2="+db2);
		
		//과학적 지수 표기방법: E, e
		double db3=8e-2;// 8*10^-2
		double db4=8e+5;// 8*10^5
		
		System.out.println("db3="+db3);
		System.out.println("db4="+db4);
		
		float ft5=900e-3F;
		System.out.println("ft5="+ft5);
		
	}//main
}//class


