package kr.kh.study.vo;

import lombok.Data;

@Data
public class CommentVO {
	int co_num; 
	String co_contents; 
	int co_bo_num; 
	String co_me_id;
}
