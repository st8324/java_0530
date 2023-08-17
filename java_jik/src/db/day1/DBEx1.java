package db.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBEx1 {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String dbId = "root";
		String dbPw = "root";
		Connection con = dbConnect(url, dbId, dbPw);
		String id = "ABC123";
		String pw = "root";
		//insertMember(con, id, pw);
		//deleteMember(con, id);
		//updateMember(con, id, 10);
		//System.out.println("Signup success!");
		ArrayList<Member> list = getMemebers(con);
		for(Member tmp : list) {
			System.out.println(tmp);
		}
	}
	public static ArrayList<Member> getMemebers(Connection con) throws SQLException{
		ArrayList<Member> list = new ArrayList<>();
		String sql = "select * from member";
		ResultSet rs = null;
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			String me_id = rs.getString(1);
			String me_pw = rs.getString(2);
			int me_board_count = rs.getInt(3);
			Member member = new Member(me_id, me_pw, me_board_count);
			list.add(member);
		}
		return list;
	}
	
	public static int insertMember(Connection con, String id, String pw) throws SQLException {
		/*
		String sql = "insert into member(me_id, me_pw) values('"+"asdasd1"+"','"+"asdasd1"+"')";
		Statement stmt = null; 
		stmt = con.createStatement();
		stmt.execute(sql);
		*/
		String sql = "insert into member(me_id, me_pw) values(?,?)";
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		//쿼리가 적용된 행의 개수를 리턴. Mysql에서 쿼리 실행 시 x row(s) affected에서 x에 해당
		return pstmt.executeUpdate();
	}
	public static int deleteMember(Connection con, String id) throws SQLException {
		String sql = "delete from member where me_id = ?";
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	public static int updateMember(Connection con, String id, int count) throws SQLException {
		String sql = "update member set me_board_count = ? where me_id = ?";
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setString(2, id);
		return pstmt.executeUpdate();
	}
	//MySql과 연결 
	public static Connection dbConnect(String url, String id, String pw) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//url : jdbc:dbms종류:url주소
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("Connection Fail!");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found!");
			return null;
		}
		System.out.println("Connection Success!");
		return con;
	}
	
}
