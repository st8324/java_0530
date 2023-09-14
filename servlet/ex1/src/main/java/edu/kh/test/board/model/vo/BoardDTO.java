package edu.kh.test.board.model.vo;

import lombok.Data;

@Data
public class BoardDTO {
	int BOARD_NO; 
	String BOARD_TITLE; 
	String BOARD_CONTENTS; 
	String BOARD_WRITER;
}
