package day10;
//컴파일 타임 에러:FileNotFoundException,IOException
//런타임 에러: ArithmeticException,ArrayIndexOutOfBoundsException,NullpointerException,...
class A{
	void sub() throws ArithmeticException{
		System.out.println(3/0);
	}
}
class B{
	void foo() throws ArithmeticException{
		A a = new A();
		try {
		a.sub();
		}catch(ArithmeticException e) {
			System.out.println("연산오류:"+e.getMessage());
		}
	}
}
public class ExceptionTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b =new B();
		try {
		b.foo();
		}catch(Exception e) {
			System.out.println("연산오류 입니다. 분모다 0이면 안돼요");
		}
	}

}
