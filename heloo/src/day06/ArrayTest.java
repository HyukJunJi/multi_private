package day06;

public class ArrayTest {

	public static void main(String[] args) {
		int x=10;
		int y=x;
		System.out.println(x==y);//값을 비교
		
		int a[]= {1,2,3,4};
		int b[]= {1,2,3,4};
		System.out.println("a==b: "+(a==b));//주소값 비교
		
		int[] c;
		c=a;//얕은 복사. 원본배열의 주소값을 할당함
		System.out.println("a==c: "+(a==c));
		//이 경우 a, c 둘 중 하나의 요소값을 변경하면 같이 변경된다
		c[1]=888;

		for(int v:a) {
			System.out.println(v);
		}
		
		//깊은 복사==> clone()메서드 사용
		//배열 a를 카피하여 새로운 배열을 만든다
		//복사한 배열을 수정해도 원본 배열은 영향받지 않는다
		int []d=a.clone();
		System.out.println("-----------------");
		
		for(int v:d) {
			System.out.println(v);
		}
		
		d[1]=2;
		
		System.out.println("---배열 d---------");
		for(int v:d) {
			System.out.println(v);
		}
		
		System.out.println("---배열 a-----------");
		for(int v:a) {
			System.out.println(v);
		}
		
		
	}

}






