package day09;

public class ExceptionTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] fruits= {"Apple","Grape","Orange"};
		try {
		for(int i =0;i<=3;i++) {
			System.out.println(fruits[i]);
		}
		}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("인덱스 초과");
		}
		System.out.println("반드시 실행되어야할 코드");
	}

}
