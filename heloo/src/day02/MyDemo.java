package day02;

public class MyDemo {
	//1. 단문 주석
	/*2. 복문 주석
	 * 	  여러 라인 주석
	 */
	/**
	 * 3. 문서화 주석
	 * => javadoc 를 이용하면 api 문서를 만들어준다.
	 */
	
	//public: 접근 지정자(access modifier) <=> private
	//static : 클래스 지정자 (class modifier)
	//void : 반환값이 없다는 의미	
	static public void main(String a []) {
		System.out.println("~~~ MyDemo ~~~~");
		System.out.print("안녕 자바");
		System.out.print("\n반갑습니다~~");
		System.out.println("저는 홍길동입니다");
		/*escape 문자
		 * \n : 개행문자 (줄바꿈이 일어난다)
		 * \t : 탭 키 만큼 띄어쓰기를 한다
		 * \" : 쌍따옴표를 출력하고자 할 때 사용
		 * \' : 홑따옴표
		 * \\ : 역슬래시(\)를 출력하고자 할때
		 * \r : 캐리지리턴. 커서를 맨 앞으로 이동시킨다
		 * */
		
		//syso + Ctrl+spacebar
		System.out.println("----------------");
		//Ctrl+Alt+ 방향키아래
		System.out.println("국어\t영어\t수학");
		System.out.println("----------------");
		System.out.println("98\t87\t65");
		System.out.println("----------------");
		
		/* 김소월 님의 '진달래 꽃'
		 * "나보기가 역겨워 가실 때에는 ..."
		 * */
		System.out.println("김소월 님의 \'진달래 꽃\'");
		System.out.println("\"나보기가 역겨워 가실 때에는 ...\"");
		
		System.out.println("역슬래시(\\)");
		System.out.println("hello world ~\rA");
		System.out.println("********************");
		
		//System.out.printf("출력서식", 출력할내용들...)
		//출력서식: %지시사
		/* %d : 정수형식으로 출력
		 * %f : 소수점 형식으로 출력
		 * %s : 문자열 형식으로 출력
		 * %c : 문자
		 * %b : boolean형식으로 출력
		 * %n : 줄바꿈
		 * */
		String name="김철수";
		int age=27;
		System.out.printf("제 이름은 %s이고 제 나이는 %d세 입니다%n", name,age);
		System.out.println("제 이름은 "+name+"이고 나이는 "+age+"세 입니다");
		
		System.out.printf("제 평균성적은 %f점 입니다\n", 93.555552);
		System.out.printf("평균성적: %.2f점%n", 93.555552); //소수점 이해 2자리까지 출력
		
		System.out.printf("%4d%n", 1);//4자리를 차지하고 1을 출력
		System.out.printf("%4d%n", 10);//4자리를 차지하고 1을 출력
		System.out.printf("%4d%n", 100);//4자리를 차지하고 1을 출력
		//-를 사용하면 왼쪽 정렬이 된다
		System.out.printf("%-4d%n", 1);//4자리를 차지하고 1을 출력
		System.out.printf("%-4d%n", 10);//4자리를 차지하고 1을 출력
		System.out.printf("%-4d%n", 100);//4자리를 차지하고 1을 출력
		//0을 이용하면 오른쪽 정렬을 하면서 남은 공간의 왼쪽 자리는 0으로 채운다
		System.out.printf("%04d%n", 100);
		//4자리를 차지하고 100을 출력하고 앞에 남은 공간을 0으로 채운다
		
	}//main()
}//class




