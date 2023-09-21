package day07;
import java.io.*;
import java.util.Scanner;
public class FileWriterTest {
//java.io 패키지
//-파일에 쓰기: FileOutputStream (1byte기반),FileWriter(char기반 -2byte기반)
//System.out		멀티미디어 파일						텍스트 기반
//-파일 읽기 FileInputStream(1byte기반), FileReader(char 기반-2byte기반)
//System.in

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("일기장에 쓸 내용을 입력하세요.");
		String line=sc.nextLine();
		System.out.println(line);
//		java.io.FileWriter 의 메서드
//		public void write(String str,int off,int len) throws
		FileWriter fw =new FileWriter("20230907.txt");
		fw.write(line,0,line.length());
		fw.close();
		System.out.println("파일에 쓰기완료");
	}
	

}
