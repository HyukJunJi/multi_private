package day11;

import java.util.ArrayList;
import java.util.List;

//import com.sun.tools.javac.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("여러 도형의 면적을 구합니다~~");
		System.out.printf("가로: %d, 세로: %d 인 도형 면적-------\n",12,10);
		
		//사각형 객체 생성해서 area()호출하기
		Rectangle re=new Rectangle();
		re.area(12, 10);
		//직삼각형 객체 생성해서 area()호출하기
		Triangle tr =new Triangle();
		tr.area(12, 10);
		//원 객체 생성해서 area()호출하기
//		Circle ci = new Circle();[x]
//		Circle도 추상클래스
//		추상클래스는 타입 선언은 할 수 있으나 인스턴스화는 할 수 없다
		Circle cr=new SubCircle(); //[o]
		cr.area(12, 10);
		((SubCircle)cr).area(12);
		//Shape sp=new Shape()[x]
		Shape sp =new Rectangle();
		sp.area(8, 5);
		
		SubCircle sc= new SubCircle();
		sc.area(8);
		
		//rt,tr,cr,sp,sc를 저장할 배열을 생성하고 저장한 후 반복문 돌려서 면적을 출력하세요.
		//20,30
		//반지름:20
		
		Shape [] ar = {re,tr,cr,sp,sc};
		for(Shape a:ar) {
			if( a instanceof SubCircle) {
				((SubCircle)a).area(20);
			}
			else {
				a.area(20, 30);
			}
		}
		
		List<Shape> list =new ArrayList<>();
		
		list.add(re);
		list.add(tr);
		list.add(cr);
		
		for(Shape a:list) {//ctrl+shift+o
			if(a instanceof SubCircle) {
				((SubCircle)a).area(4);
			}
			a.area(4, 9);
		}
		
		for(int i =0;i<list.size();i++) {
			Shape obj = list.get(i);
			System.out.println("************");
			if(obj instanceof SubCircle) {
				((SubCircle)obj).area(4);
			}
			else {
				obj.area(4, 9);
			}
		}
	}

}
