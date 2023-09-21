package day02;
import javax.swing.JOptionPane;
class score{
	private String a= JOptionPane.showInputDialog("체육:");
	private String b= JOptionPane.showInputDialog("수학:");
	private String c= JOptionPane.showInputDialog("영어:");
	private String d= JOptionPane.showInputDialog("국어:");
	private int A = Integer.parseInt(a);
	private int B = Integer.parseInt(b);
	private int C = Integer.parseInt(c);
	private int D = Integer.parseInt(d);
	public String toString() {
		return "1학기 평균 점수는:"+(A+B+C+D)/4;
	}
}
public class Exam02 {
	public static void main(String []args) {
		
		score sc =new score();
		System.out.println(sc.toString());
		
		
		
		
	}
}
