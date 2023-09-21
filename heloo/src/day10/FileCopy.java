package day10;

import java.io.*;
import java.util.*;

/*InputStream /OutputStream  | Reader/Writer
 * --------------------------------------------
 * 1byte기반 데이터를 읽고 쓴다    | 2byte기반(char)
 * image 파일 같은 것은..	     |  텍스트 파일 같은것들..
 * FileInputStream           | FileReaderr
 * FileOutputStream          | FileWriter
 * PrintStream               | PrintWrtier
 * ...
 *  
 */
public class FileCopy {
	public static void imageCopy(String src,String target) throws FileNotFoundException,IOException {
		FileInputStream fis=null;
		FileOutputStream fos =null;
		
		fis = new FileInputStream(src); //FileNotFoundException
		fos = new FileOutputStream(target);
		int total=0;
		int n = 0;
		byte data[] = new byte[1024];
		while((n=fis.read(data))!=-1) { //IOException
			fos.write(data,0,n);
			fos.flush();
			System.out.println("n: "+n); //읽은 바이트수
			total+=n;
		}
		System.out.println("총"+total+"bytes 파일 카피 완료!!");
		if(fis!=null) fis.close(); //IOExcption
		if(fos!=null) fos.close();
	}
//	C:/multicamp/JavaWorkspace/circle.png
//	C:/multicamp/JavaWorkspace/circle_copy.png
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("카피할 원본 파일명을 입력하세여=>");
		String file1 = sc.nextLine();

		System.out.println("카피할 원본 파일명을 입력하세여=>");
		String file2 = sc.nextLine();

		System.out.println(file1 + "파일을" + file2 + "로 카피합니다.");

		try {
		FileCopy.imageCopy(file1, file2);
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없어요!!"+e.getMessage());
		}
		sc.close();
	}

}
