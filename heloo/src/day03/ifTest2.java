package day03;
import java.util.Scanner;

public class ifTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2자리 정수를 입력하세요=>");
		int num = sc.nextInt();
		if(num<10||num>100) {
			System.out.println("입력 오류");
		}
		else {
			if(num%11==0) {
				System.out.println("10의 자리와 1의자리가 같다");
			}
			else {
				System.out.println("같지 않다.");
			}
		}
		int n1 = num/10;
		int n2 = num%10;
		System.out.println("n1:"+n1+" n2:"+n2);
		if(n1==n2) {
			System.out.println("OK");
		}else {
			System.out.println("NO");
		}
		String a = (num%11==0)? "ok":"No";
		System.out.println(a.toLowerCase());
		System.out.println((n1==2)?"ok":"no");
		sc.close();
	}
}
