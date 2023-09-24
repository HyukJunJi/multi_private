package delivery;

/*
 * 작성자: 지혁준
 * 작성일:2023.09.24
 * 프로젝트명: 소켓통신을 활용한 배달앱 사용자와 요식업 판매자에 글 게시와 주문 프로그램
 * 클래스명 : ClientShopItem
 * 내용 : 사용자가 보낸 데이터를 관리하기 위한 클래스
 */
public class ShopClientItem {

	private String name;
	private String price;
	private String image;
	private String num;
	private String client;
	public ShopClientItem(String data) {
		// TODO Auto-generated constructor stub
		/*
		 * 데이터를 받을때 객체로 보내니 toString만 호출하는 모습이 보여서 /를 넣어 보낸뒤 split으로 값을 넣어줬다
		 */
		String []item=data.split("/");
		this.name = item[0];
		this.price = item[1];
		this.image = item[2];
		this.num=item[3];
		this.client = item[4];
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String toString() {
		return name+"/"+price+"/"+image+"/"+num+"/"+client+"/shop";
	}

}
