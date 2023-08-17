package db.day1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private String me_id;
	private String me_pw;
	private int me_board_count;

}
