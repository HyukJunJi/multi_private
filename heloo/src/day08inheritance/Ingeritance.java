package day08inheritance;

public class Ingeritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human h =new Human();
		h.name="홍길동";
		h.height=123;
		h.showInfo();
		Superman g = new Superman("eden",232,232);
		
		g.showInfo();
		Human gh= new Superman("eden",222,222);
		gh.showInfo();
		
		
		Aquaman a =new Aquaman();
		a.showInfo();
		g.showInfo("ddd");
		//다형성
		//부모 자식의 상속관계를 맺을 경우
		//부모타입 변수 = new 자식타입변수()
		System.out.println(((Superman)gh).power);
	}	

}
