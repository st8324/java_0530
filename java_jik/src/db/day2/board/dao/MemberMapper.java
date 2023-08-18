package db.day2.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.day2.board.vo.MemberVO;

public class MemberMapper implements MemberDAO {

	private Connection con;
	
	public MemberMapper(Connection con) {
		this.con = con;
	}

	@Override
	public MemberVO getMember(String id) {
		//쿼리를 생성
		String sql ="select me_id, me_pw, me_board_count from member where me_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String me_id = rs.getString(1);
				String me_pw = rs.getString(2);
				int me_board_count = rs.getInt(3);
				return new MemberVO(me_id, me_pw, me_board_count);
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}

	@Override
	public void insertMember(String id, String pw) {
		String sql = "insert into member(me_id,me_pw) values(?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//?설정
			ps.setString(1, id);
			ps.setString(2, pw);
			//실행
			ps.executeUpdate();
		} catch (SQLException e) {

		}
	}

	@Override
	public void deleteMember(String id) {
		String sql = "delete from member where me_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//?설정
			ps.setString(1, id);
			//실행
			ps.executeUpdate();
		} catch (SQLException e) {

		}
	}

}
