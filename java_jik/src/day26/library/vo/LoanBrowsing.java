package day26.library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

//대출 열람(도서대출 기록)
@Data
public class LoanBrowsing implements Serializable {

	private static final long serialVersionUID = 4272632230761810647L;

	private Book book;//대출 도서
	private Date loanDate;//대출일
	private Date returnDate;//반납일
	
	public LoanBrowsing(Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
	}
	
	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(loanDate);
	}
	
}








