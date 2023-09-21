package day06;

public class MyRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV t1 = new TV();
		t1.turnoff();
		t1.change(2);
		System.out.println(t1.toString());
		TV t2 = new TV(100,230000,"삼성","전자랜드");
		t2.change(3);
		t2.turnon();
		t2.wifi="SK";
		System.out.println(t2.toString());
	}
	

}
