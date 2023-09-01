package kr.kh.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private int bo_num, bo_ori_num, bo_views, bo_up, bo_down, bo_bt_num, bo_comment;
	private String bo_title, bo_me_id, bo_contents;
	private Date bo_reg_date, bo_up_date;
	
	private List<FileVO> fileVoList;

	public String getBo_up_date_str() {
		if(bo_up_date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(bo_up_date);
	}
	public String getBo_reg_date_str() {
		if(bo_reg_date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(bo_reg_date);
	}
}
