package day08;

public class Cafe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoffeMachine cm =new CoffeMachine();
		
		cm.makeTea(2,1,3);
		cm.makeTea(2,4);
		String s =cm.makeTea(1);
		System.out.println(s);
		cm.makeTea(1,2L);
		cm.makeTea(3L,2);
		Yuja y= new Yuja();
		y.setSugar(2);
		y.setYuja(2);
		System.out.println(cm.makeTea(y));
	}

}
