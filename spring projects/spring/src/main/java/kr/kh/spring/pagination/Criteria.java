package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class Criteria {
	private int page; //현재 페이지
	private int perPageNum; //한 페이지에서 컨텐츠 개수
	private String type;//검색 타입
	private String search;//검색어
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
		type="0";//전체 검색
		search="";
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
		type="0";
		search="";
	}
	//게시글 리스트에서 현재 페이지에 맞는 게시글을 가져오기 위한 시작 번지 
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
	public String getUrl(int page) {
		return "?page=" + page + "&type="+type +"&search="+search;
	}
	public String getCurrentUrl() {
		return "?page=" + page + "&type="+type +"&search="+search;
	}
}
