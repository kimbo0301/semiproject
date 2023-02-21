package semiproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.EmpVO;

public class ProblemDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@mydb.cwnyvgf2watg.ap-northeast-2.rds.amazonaws.com:1521:orcl";
	String user = "scott";
	String password = "tigertiger1";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();
	
	public ProblemDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("db 연결 실패");
			e.printStackTrace();
		}
		
		
	}
	
	

	
	
	public ProblemVO problem (int rnd) {
		sb.setLength(0);
		ProblemVO vo = null;
		sb.append("SELECT * ");
		sb.append("FROM problem_table ");
		sb.append("WHERE problem_no = ? "); 

		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, rnd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String priblem = rs.getString("problem");
				vo = new ProblemVO(priblem);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vo;
	}
	
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	
	
}