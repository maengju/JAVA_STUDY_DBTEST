package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	private Connection conn;
	private PreparedStatement pstmt;  //가이드 역할
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	public InsertTest() {

		try {
		//driver loading
		Class.forName(driver); //이름만 알고 정확히 모를경우
		// 파일명(풀네임 - 패키지명.파일명)을 주면 Class으로 생성을 해준다.
		System.out.println("driver loading complete");
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace(); // 에러 내용을 출력
		}
	}
	
	public void getConnection() {
		try {
		
		conn = DriverManager.getConnection(url,username,password ); //오라클 드라이버 3개중 많이쓰는게 thin
									//(URL,USERNAME,PASSWORD)
		System.out.println("접속성공");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.print("키 입력 : ");
		double height = scan.nextDouble();
		
		
		
		try {
			//접속
			this.getConnection();
			
			String sql = "insert into dbtest values(?, ?, ?, sysdate)";
			//생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 매핑
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3,height);
			
			//실행
			int su = pstmt.executeUpdate();
			
			System.out.println(su+"개의 행이 만들어졌습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//에러가 있건없건 무조건 실행
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.insertArticle();
	}//main method

	
}
