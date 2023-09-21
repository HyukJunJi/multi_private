package day07;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("20230907.txt");
		System.out.println("파일크기:"+file.length()+"bytes");
		char[]data = new char[10];
		FileReader fr=new FileReader(file);
		//int n=fr.read(data);
		int n =0;
		while((n=fr.read(data))!=-1) {
			String content = new String(data,0,n);
			System.out.println(content);
			System.out.println("n:"+n);
		}
		
		
		String contents=new String(data);
		System.out.println(contents);
	}

}
