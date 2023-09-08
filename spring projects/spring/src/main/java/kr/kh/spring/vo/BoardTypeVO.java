package kr.kh.spring.vo;

import java.util.List;

import lombok.Data;

@Data
public class BoardTypeVO {
	int bt_num;
	String bt_title;
	List<BoardAuthorityVO> baList;
	String bt_authority;
}
