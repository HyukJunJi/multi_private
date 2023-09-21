package day06;
//메서드, function:기능
//[1]인스턴스 메서드: non-static 메서드 "객체명.메서드"
//[2]클래스 메서드 :static 메서드,	"클래스명.메서드"
public class MyDemo {
	public void showStar() {
		System.out.println("★★★★");
	}
	public static void showSnail() {
		System.out.println("@@@@");
	}
	public static void showShape(char ch,int cnt) {
		for(int i =0;i<cnt;i++) {
			System.out.print(ch+" ");
		}
		System.out.println();
	}
	public void greeting(String term,String name) {
		System.out.println(term+" "+name+"님~~");
	}
	public void greetingMany(String term,String ... names) {
		System.out.print(term+" ");
		for(String name:names) {
			System.out.print(name+"님");
		}
	}
}
