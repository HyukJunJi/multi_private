package day02;
import javax.swing.JOptionPane;
public class Exam01 {
	public static void main(String[] args) {
		String age= JOptionPane.showInputDialog("당신의 나이는?");
		if(age==null) {
			return;
		}
		if(age.equals("")) {
			System.out.println("나이를 입력해야죠");
			return;
		}
		System.out.println(age+"세 이군요!");
		
		System.out.println("내년에는"+age+1+"이군요" );
	}
}
