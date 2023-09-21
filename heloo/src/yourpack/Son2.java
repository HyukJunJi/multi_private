package yourpack;
import mypack.*;
public class Son2 extends Parent{
	public void go() {
		System.out.println("publicVar:"+publicVar);
		System.out.println("protectedVar:"+protectedVar);
//		System.out.println("defaultVar:"+defaultVar); //같은 패키지 있어야 접근가능
//		System.out.println("publicVar:"+privateVar);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
