package day10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file="src/day10/database.properties"
				;
		FileInputStream fis=new FileInputStream(file);
		
		Properties prop=new Properties();
		prop.load(fis);
		
		fis.close();
		
		String db=prop.getProperty("DbType");
		System.out.println(db);
		System.out.println(prop.getProperty("DbUrl"));
		System.out.println(prop.getProperty("DbUser"));
		System.out.println(prop.getProperty("DbPwd"));
		
		System.out.println(prop.getProperty("Msg","디폴트 메세지 입니다."));
	}

}
