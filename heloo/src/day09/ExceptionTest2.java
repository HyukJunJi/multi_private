package day09;

public class ExceptionTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i <= 5; i++) {

				int x = 50 / (i - 3);
				System.out.println("x:" + x);

			}
		} catch (ArithmeticException e) {
			System.out.println("초과");
		}
		System.out.println("The End~~");
	}

}
