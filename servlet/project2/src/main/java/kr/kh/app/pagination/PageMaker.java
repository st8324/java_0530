package kr.kh.app.pagination;

import lombok.Data;

//한 페이지네이션의 정보
//시작/끝 페이지 번호, 이전/다음 버튼 활성화 여부, 보여주는 페이지 최대 개수, 현재 페이지 정보
@Data
public class PageMaker {

	private int startPage;	//페이지네이션에서 시작 페이지 번호
	private int endPage;	//페이지네이션에서 마짐가 페이지 번호
	private boolean prev;	//이전 버튼 활성화
	private boolean next;	//다음 버튼 활성화
	private int displayPageNum;	//보여주는 페이지 최대 개수
	private Criteria cri;	//현재 페이지 정보
	private int totalCount; //게시글 전체수 => endPage 계산을 위해 필요
	//
	//페이지네이션 정보를 계산하는 메서드 
	public void calculate() {
		//주어지는 정보 : 현재 페이지 정보, 전체 게시글 수, 한 페이지네이션에서 보여주는 페이지 최대 개수
		//예시 : 현재 페이지가 1페이지고, 한 페이지에 게시글이 5개, 전체 게시글 15, 5개
		
		//현재 페이지를 이용하여 최대 가능한 마지막 페이지를 계산 => 5
		//cri.getPage()/(double)displayPageNum = > 1 / 5.0 => 0.2, ceil(0.2) => 1
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		
		//마지막 페이지네이션의 마지막 페이지 
		int lastEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		//마지막 페이지네이션이면 
		if(endPage > lastEndPage) {
			endPage = lastEndPage;
		}
		//첫 페이지네이션이면 : 시작페이지가 1이면 이전버튼 비활성화
		prev = startPage == 1 ? false : true;
		//마지막페이지네이션이면 : lastEndPage와 endPage가 같으면 다음 버튼 비활성화
		next = endPage == lastEndPage ? false : true;
	}
	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		calculate();
	}
	public String getUrl(int page) {
		return "/board/list?page=" + page;
	}
	public String getNextPageUrl() {
		return "/board/list?page=" + (endPage + 1);
	}
	public String getPrevPageUrl() {
		return "/board/list?page=" + (startPage - 1);
	}
}







