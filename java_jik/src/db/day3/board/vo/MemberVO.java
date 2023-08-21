package db.day3.board.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private int me_board_count;
	
	//생성자
	public MemberVO(String id, String pw) {
		this.me_id = id;
		this.me_pw = pw;
	}
	
	//다른 setter와 getter : 날짜 관련해서 2023-08-21
}
