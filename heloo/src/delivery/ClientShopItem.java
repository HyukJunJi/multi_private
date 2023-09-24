package delivery;


/*
 * @author: 지혁준
 * @version:0.1
 * @since:2023.09.24
 * 프로젝트명: 소켓통신을 활용한 배달앱 사용자와 요식업 판매자에 글 게시와 주문 프로그램
 * 클래스명 : ClientShopItem
 * 내용 : 판매자가 보낸 데이터를 관리하기 위한 클래스
 */
public class ClientShopItem {
	private String name;
	private String price;
	private String image;
	private String num;
	private String client;
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
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
	public ClientShopItem(String data) {
		String []item=data.split("/");
		this.name = item[0];
		this.price = item[1];
		this.image = item[2];
		this.num=item[4];
		this.client=null;
	}
	public String toString() {
		return name+"/"+price+"/"+image+"/"+num+"/"+client+"/client";
	}

}
