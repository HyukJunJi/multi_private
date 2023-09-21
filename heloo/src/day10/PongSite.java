package day10;

import java.util.*;

import mychat.NotSupportedNameException;

public class PongSite {
	public void join(String name, String userId, String pwd) throws NotSupportedNameException {
	    System.out.println(">>>회원 가입<<<");

	    String surname = name.split(" ")[0]; // Assuming names are in "Surname Givenname" format.

	    if(surname.equals("퐁")) {
	        System.out.println(name + "님 회원가입을 환영합니다");
	    } else if(surname.equals("콩")) {
	        throw new NotSupportedNameException("콩씨는 절대로 회원가입 불가!!!");
	    } else {
	        throw new NotSupportedNameException("퐁씨 성이 아닌 분들은 이용에 제한이 있습니다.");
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("이름: ");
		String name = sc.nextLine();
		
		System.out.println("아이디: ");
		String userId = sc.nextLine();

		System.out.println("비밀번호: ");
		String pwd = sc.nextLine();
		
		PongSite ps =new PongSite();
		try {
			ps.join(name, userId, pwd);
		} catch (NotSupportedNameException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
