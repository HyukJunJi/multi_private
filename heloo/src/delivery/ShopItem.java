package delivery;


/*
 * @author: 지혁준
 * @version:0.1
 * @since:2023.09.24
 * 프로젝트명: 소켓통신을 활용한 배달앱 사용자와 요식업 판매자에 글 게시와 주문 프로그램
 * 클래스명 : ShopItem
 * 내용 : 판매자가 올린 상품을 사용자에게 객체로 묶어 보내위한 클래스
 */
public class ShopItem {
	private String name;
	private String price;
	private String image;
	static int num=0;
	public ShopItem() {
		
	}
	public ShopItem(String name, String price, String image) {
		this.name = name;
		this.price = price;
		this.image = image;
		num++;
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
	public String toString() {
		return name+"/"+price+"/"+image+"/Shopitem/"+num;
	}

}
