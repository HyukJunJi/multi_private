package day09;

public class ExceptionTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] args <-명령줄 인수
		try {
			String num1 = args[0];
			String num2 = args[1];
//		javac -d . ExceptionTest4.java
//		java day09.ExceptionTest4 국어ㅅㅅ 영어
//		java day09.ExceptionTest4 100 88
			System.out.println("num1:" + num1);
			System.out.println("num2:" + num2); // ctrl +alt +방향키
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);

			int n3 = n1 / n2;
			System.out.println("n3:" + n3);
			String str = null;
			System.out.println(str.toUpperCase());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("명령줄 인수를 2개 주어야해요");
		} catch (NumberFormatException e) {
			System.out.println("명령줄 인수는 숫자로 입력해야해요!");
		} catch (ArithmeticException e) {
			System.out.println("0을 입력해선 안돼요!");
		} catch (Exception e) {
			System.out.println("기타 예상치 못한 에러 발생" + e.getMessage());
		}finally {
		System.out.println("반드시 실ㅇ행");
				
		}
		System.out.println("thend");

	}
}
