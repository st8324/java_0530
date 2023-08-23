package kr.kh.app.vo;

import lombok.Data;

@Data
public class MemberVO {

	private String me_id;
	private String me_pw;
	private int me_board_count;
	
	public MemberVO(String id, String pw) {
		this.me_id = id;
		this.me_pw = pw;
	}
}
