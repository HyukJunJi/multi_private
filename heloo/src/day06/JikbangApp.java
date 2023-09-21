package day06;

public class JikbangApp {

	public static void main(String[] args) {
		// 클래스: 객체를 만들어내는 틀
		// 객체 : 클래스를 통해 만들어진 구현물 => object, instance
		
		//클래스타입 변수 =new 생성자();
		House h1=new House();
		House h2=new House();
		
		System.out.println("h1.owner: "+h1.owner);//객체명.속성명
		System.out.println("h2.owner: "+h2.owner);
		
		h1.owner="홍길동";
		h1.room=3;
		h1.addr="서울 강남구 역삼동";
		
		h2.owner="김철수";
		h2.room=2;
		h2.addr="서울 마포구 합정동";
		
		System.out.println("h1.owner: "+h1.owner);
		System.out.println("h2.owner: "+h2.owner);
		
		h1.printInfo();//객체명.메서드명()
		h2.printInfo();
		System.out.println(h1);
		System.out.println(h2);
		
		//House객체 하나 더 생성==> printInfo()호출하기
		House h3=new House();
		h3.printInfo();
		
		h3.owner="김영희";
		h3.room=5;
		h3.addr="인천";
		
		h3.printInfo();
		
		
		//rent()메서드도 호출해보기
		String info=h3.rent("전세",5000);
		//h3.rent(); //[x]
		System.out.println(info);
		
		String info2=h1.rent("월세", 30);
		System.out.println(info2);
		System.out.println(h2.rent("매매", 8000));
		
	}

}













