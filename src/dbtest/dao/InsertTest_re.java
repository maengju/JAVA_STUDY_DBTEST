package dbtest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest_re {
	private Connection conn;
	private PreparedStatement pstmt; //���̵忪��
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:orcle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String passaword = "bit";
	
	public InsertTest_re() {
		
		try {
			//driver loading
			Class.forName(driver);
			//���ϸ�(Ǯ���� - ��Ű����.���ϸ�)���ָ� Class�� ������ ���ش�.
			System.out.println("driver loading complete");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); //���������� ���
		}
	}//1.
	
	
	public void getConnection() {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	//===================================================================
	public static void main(String[] args) {
		

	}

}
