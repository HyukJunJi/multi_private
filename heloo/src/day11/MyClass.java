package day11;
//MyClass가 MyInter, YourInter를 상속받아보자
//클래스가 인터페이스를 상속받을 때는 implements로 상속받으며,
//다중 상속이 가능하다
public class MyClass implements MyInter,YourInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass mc =new MyClass();
		mc.foo();
		String s= mc.bar();
		System.out.println(s);
		//Greeting 출력
		System.out.println(mc.GREETING);
		System.out.println(MyClass.GREETING);
		System.out.println(YourInter.GREETING);
		
		//mc.GREETING="HELLO";[x]
		//MyInger mi =new MyInter();
		MyInter mi =new MyClass();
		YourInter yi =new MyClass();
		
		((MyClass)yi).foo();
		((MyInter)yi).foo();
		
		System.out.println(yi.bar());
		System.out.println(yi.GREETING);
	}

	@Override
	public String bar() {
		// TODO Auto-generated method stub
		return "bar";
	}

	@Override
	public void foo() {
		// TODO Auto-generated method stub
		System.out.println("foo");
	}

}
