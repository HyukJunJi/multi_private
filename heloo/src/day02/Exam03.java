package day02;

import javax.swing.JOptionPane;

class circle{
	private float pi = 3.14f;
	private String r= JOptionPane.showInputDialog("������:");
	private float R = Float.parseFloat(r);
	public float getter() {
		return pi*R*R;
	}
	
	
}
public class Exam03 {
	
	public static void main(String []args) {
		circle ci= new circle();
		System.out.println("���� ������:"+ci.getter());
//		String circle1=String.format("%.2f",circle);
//		소수점 둘째자리까지 float형으로 변환 string을
		
	}
}
