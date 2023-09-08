package kr.kh.spring.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_role;
	private String me_session_id;
	private Date me_session_limit;
	
	private boolean autoLogin;
}
