package day02;
import javax.swing.JOptionPane;
class score{
	private String a= JOptionPane.showInputDialog("ü��:");
	private String b= JOptionPane.showInputDialog("����:");
	private String c= JOptionPane.showInputDialog("����:");
	private String d= JOptionPane.showInputDialog("����:");
	private int A = Integer.parseInt(a);
	private int B = Integer.parseInt(b);
	private int C = Integer.parseInt(c);
	private int D = Integer.parseInt(d);
	public String toString() {
		return "1�б� ��� ������:"+(A+B+C+D)/4;
	}
}
public class Exam02 {
	public static void main(String []args) {
		
		score sc =new score();
		System.out.println(sc.toString());
		
		
		
		
	}
}
