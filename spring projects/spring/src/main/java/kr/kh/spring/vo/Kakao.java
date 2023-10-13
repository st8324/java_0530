package kr.kh.spring.vo;

import lombok.Data;

@Data
public class Kakao {
	String access_token;
	String token_type;
	String refresh_token;
	String scope;
	int expires_in;
	int refresh_token_expires_in;
}
