package day07;

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1 = new File("20230907.txt");
		System.out.println("file1 파일 존재 여부:"+file1.exists());
		File file2=new File("src/day07/Cafe.java");
		
		System.out.println("file2 파일 존재 여부:"+file2.exists());
		System.out.println("file2 디렉토리 여부:"+file2.isDirectory());
		System.out.println("file2 파일  여부:"+file2.isFile());
		System.out.println("file2.getPath() 여부:"+file2.getPath());
		System.out.println("file2.getAbsolutePath():"+file2.getAbsolutePath());
		
		File file3 = new File("src/sample");
		System.out.println("file3 디렉토리 여부:"+file3.isDirectory());
		if(!file3.exists()) {
			boolean b= file3.mkdirs();
			System.out.println("생성 여부:"+b);
		}
		boolean b2 = file3.delete();
		System.out.println("삭제 여부:"+b2);
	}

}
