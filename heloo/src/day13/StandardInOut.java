package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*키보드로 입력한 내용을
 * 콘솔에 출력해보자
 * 
 * 데이터소스([키보드],파일,컴퓨터)
 * : 키보드==>System.in =>InputStream타입 (1byte기반)
 * ==>InputStreamReader (2byte로 조합하여 읽는다)
 * ==>BufferedReader (버퍼에 모아서 읽어들이며, 줄단위로 입력받는 메서드가 있다:readLine())
 * 
 * 데이터목적지([콘솔],파일,컴퓨터,프린터)
 * : 콘솔 ==>System.out => PrintStream타입
 * ==>OutputStreamWriter
 * ==>BufferdWriter
 * */
public class StandardInOut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("내용을 입력하세요");
		//키보드 입력
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		//콘솔 출력
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line="";
		while((line=key.readLine())!=null) {
			out.write(line+"\n");
			out.flush();
		}
		key.close();
		out.close();
		System.in.close();
		System.out.close();
	}

}
