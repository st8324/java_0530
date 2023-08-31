package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class Criteria {
	private int page; //현재 페이지
	private int perPageNum; //한 페이지에서 컨텐츠 개수
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	//게시글 리스트에서 현재 페이지에 맞는 게시글을 가져오기 위한 시작 번지 
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
	public String getUrl(int page) {
		return "?page=" + page;
	}
	public String getCurrentUrl() {
		return "?page=" + page;
	}
}
