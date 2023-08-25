package kr.kh.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardVO {
	private int bo_num;
	private String bo_title;
	private String bo_me_id;
	
	// 게시글 리스트에서 사용할 url을 리턴해주는 메서드 /board/detail?bo_num=1
	public String getBoardDetailUrl() {
		return "/board/detail?bo_num="+bo_num;
	}
}
