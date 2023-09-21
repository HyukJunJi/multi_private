package day06;
class Car{
	static String b="나는 car's클래스변수";
	double a=50.5;
	
}
public class StaticTest {
		int a=10;
		static int b=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("StaticTest.b="+StaticTest.b);
		System.out.println("b:"+b);
		System.out.println("---------------------------");
		
		System.out.println("Car.b="+Car.b);
		Car c1=new Car();
		System.out.println("c1.a="+c1.a);
//		System.out.println("a:"+a);
		StaticTest st = new StaticTest();
		System.out.println("st.a="+st.a);
		System.out.println("st.b="+StaticTest.b);
	}

}
