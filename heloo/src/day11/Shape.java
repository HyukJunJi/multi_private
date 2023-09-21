package day11;

public abstract class Shape { //추상 메서드를 1개라도 가지면 추상 클래스로 만들어야함
	private String info="나는 드형 클래스에요";
	public String getInfo() {
		return info;
	}
	
	abstract void area(int x, int y); //메서드 몸체없이 선언한 것 => 추상메서드
}
class Rectangle extends Shape{
	public void area(int w,int h) {
		int a= w*h;
		System.out.println("사각형 면적:"+a);
	}
}
class Triangle extends Shape{
	public void area(int w,int h) {
		double a=(w*h)/2;
		System.out.println("삼각형 면적:"+a);
	}
}
abstract class Circle extends Shape{
	final double pi=3.14;
}
class SubCircle extends Circle{
	public void area(int r,int r2) {
		
	}
	public void area(int r) {
		double k=pi*r*r;
		System.out.println("원의 면적:"+k);
	}
	
}