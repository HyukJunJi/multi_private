package day11;
interface Inter1{
	void a();
	int b();
}
interface Inter2{
	double PI =3.14;
}
interface Inter3 extends Inter1,Inter2{
	void c();
	
}
abstract class AbsClass{
	void info() {
		System.out.println("ABSCLASS");
	}
	abstract void d();
}
public class MyDemo extends AbsClass implements Inter3{

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println("a()");
	}

	@Override
	public int b() {
		// TODO Auto-generated method stub
		System.out.println("b()");
		return 100;
	}

	@Override
	void d() {
		// TODO Auto-generated method stub
		System.out.println("d()");
	}
	public void c() {
		System.out.println("c()");
	}

}
