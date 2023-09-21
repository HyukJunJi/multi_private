package mychat;
/*
 * 사용자 정의 예회 클래스 만들기
 * [1] Exception을 상속받는다.
 * [2] 생성자를 구성하고 그 안에서 super("예외메세지");를 호출한다.
 */
public class NotSupportedNameException extends Exception {
	public NotSupportedNameException() {
		super("NotSupportedNameException");
	}
	public NotSupportedNameException(String msg) {
		super(msg);
	}
}
