package day02;
import javax.swing.JOptionPane;
public class Exam01 {
	public static void main(String[] args) {
		String age= JOptionPane.showInputDialog("����� ���̴�?");
		if(age==null) {
			return;
		}
		if(age.equals("")) {
			System.out.println("���̸� �Է��ؾ���");
			return;
		}
		System.out.println(age+"�� �̱���!");
		
		System.out.println("���⿡��"+age+1+"�̱���" );
	}
}
