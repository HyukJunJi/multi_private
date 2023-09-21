package day03;
import java.util.*;
public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		int hh=date.getHours(); //deprecated => 버전 업하면서 안쓰기로 한것
		int mm=date.getMinutes();
		int ss=date.getSeconds();
		System.out.printf("현재시간은 %d:%d:%d%n",hh,mm,ss);
		
		int yy=date.getYear();
		int month=date.getMonth()+1;
		int dd=date.getDate();
		int dy =date.getDay();
		
		System.out.printf("%d년 %d월 %d일 %d요일",yy,month,dd,dy);
		
		int days=30;
		switch(month) {
		case 2: days=28;break;
		case 4:case 5:case 9: case 11: days=30;break;
		default:
			days=31;
		}
	}

}
