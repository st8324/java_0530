package kr.kh.springtest.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MemberListVO {
	ArrayList<MemberVO> list = new ArrayList<MemberVO>();
}
