package day06;
import java.lang.Math;
import java.lang.String;
public class MyDemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDemo.showSnail();
		MyDemo my= new MyDemo();
		my.showStar();
		double a = Math.pow(7, 3);
		System.out.println(a);
		String str= "Hello#asdas#aswwww#wwwwwww#cccc";
		String ss[]=str.split("#");
		for(String G:ss) {
			System.out.print(G+" ");
		}
		System.out.println();
		String str1= new String("Hello#asdas#aswwww#wwwwwww#cccc");
		String ss1[]=str.split("#");
		for(String G:ss1) {
			System.out.print(G+" ");
		}
		System.out.println();
//		MyDemo의 showShape()호출하기
		MyDemo.showShape('a', 2);
		my.greeting("ddd", "혁ㅈㄴ");
		
		my.greetingMany("반가워요", "수지","영희");
		
		YourDemo yr=new YourDemo();
		System.out.println();
		System.out.println(yr.add(1, 2));
		System.out.println(yr.multi(2.2, 3.3f));
		System.out.println(yr.div(7, (short) 4));
//		System.out.println(yr.div(2, 3));
	}

}
