package day09;

public class ExceptionTest3 {

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			try {
				int x = 50 / (i - 3);
				System.out.println("x:" + x);
			} catch (ArithmeticException e) {
				System.out.println("인덱스 초과");
			}

		}
		System.out.println("The End~~");

	}

}
