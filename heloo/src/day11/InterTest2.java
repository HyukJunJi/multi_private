package day11;

public class InterTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDemo md =new MyDemo();
		md.a();
		md.b();
		md.c();
		md.d();
		System.out.println(MyDemo.PI);
		
		Inter1 mi1=new MyDemo();
		md.a();
		md.b();
//		md.c();
//		md.d();
		
		Inter3 mi2=new MyDemo();
		mi2.a();
		mi2.b();
		mi2.c();
		
		AbsClass ac =new MyDemo();
		ac.info();
		ac.d();
		((MyDemo)ac).a();
		System.out.println(Inter2.PI);
	}

}
