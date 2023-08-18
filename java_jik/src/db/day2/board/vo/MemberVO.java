package db.day2.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {
	private String me_id;
	private String me_pw;
	private int me_board_count;
}
