package dbtest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest_re {
	private Connection conn;
	private PreparedStatement pstmt; //가이드역할
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:orcle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String passaword = "bit";
	
	public InsertTest_re() {
		
		try {
			//driver loading
			Class.forName(driver);
			//파일명(풀네임 - 패키지명.파일명)을주면 Class로 생성을 해준다.
			System.out.println("driver loading complete");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); //에러내용을 출력
		}
	}//1.
	
	
	public void getConnection() {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	//===================================================================
	public static void main(String[] args) {
		

	}

}
