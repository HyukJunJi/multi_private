package day09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class FileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fname = JOptionPane.showInputDialog("읽을 파일명을 입력하세요");
		if (fname == null)
			return;
		System.out.println(fname);
		String content = reading(fname);
		System.out.println(content);
	}

	public static String reading(String fileName) {
		String str = "";
		FileReader fr = null;
		char[] data = new char[1000];
		try {
			fr = new FileReader(fileName);
			// FileNotFoundException
			int n = 0;

			while ((n = fr.read(data)) != -1) { // IOException
				String content = new String(data, 0, n);
				str += content;// 데이터 소스 (파일) o======o
			}

			// IOException
		}
//		C:/multicamp/JavaWorkspace/heloo/src/day09/MyGui.java
		catch (FileNotFoundException e) {
			System.out.println("파일 못찾음");
		} catch (IOException e) {
			System.out.println("IOEx"+e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();// IOException
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return str;
	}

}
