package kr.kh.study.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int bo_num; 
	private String bo_title; 
	private String bo_contents; 
	private int bo_views; 
	private Date bo_reg_date; 
	private Date bo_up_date; 
	private int bo_ori_num; 
	private String bo_me_id; 
	private int bo_up; 
	private int bo_down; 
	private int bo_comment; 
	private int bo_bt_num;
}
