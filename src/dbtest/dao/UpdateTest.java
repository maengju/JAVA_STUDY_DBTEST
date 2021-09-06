package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {

	private Connection conn;
	private PreparedStatement pstmt;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	public UpdateTest() {

		try {
			Class.forName(driver);
			System.out.println("driver loading complete");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateTestArticle() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
		
		
		try {

			
			String sql = "update dbtest set age=age+1,height=height-1 where name like ?";
			this.getConnection();
			pstmt = conn.prepareStatement(sql);//생성
			pstmt.setString(1, "%"+name+"%");
			
			int su = pstmt.executeUpdate();
			System.out.println(su+"개의 행이 변경되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	
	
	
	
	
	
	//==============================================================
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateTest ut = new UpdateTest();
		ut.UpdateTestArticle();

	}

}
