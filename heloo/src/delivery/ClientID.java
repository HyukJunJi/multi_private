package delivery;
/*
* @author: 지혁준
* @version:0.1
* @since:2023.09.24
* 내용: 사용자 id 보관
*/
public class ClientID {
	private final String name;
	private final String pw;
	public ClientID(String name,String pw) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.pw=pw;
	}
	public String getName() {
		return name;
	}
	public String getPw() {
		return pw;
	}

}
