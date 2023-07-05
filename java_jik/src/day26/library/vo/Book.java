package day26.library.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Book implements Serializable {
	
	private static final long serialVersionUID = 7054033506087668340L;
	//도서번호 : 도서관에서 지정, 
	//도서명, 저자, isbn
	private String num, title, author, isbn;
	private boolean loan;//대출 여부
	
	public String toString() {
		return 	"도서번호 : " + num + "\n" +
				"도서제목 : " + title + "\n" +
				"도서저자 : " + author + "\n" +
				"ISBN   : " + isbn;
	}

	public Book(String num, String title, String author, String isbn) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	public void loanBook() {
		this.loan = true; //setLoan(true);
	}
	public void returnBook() {
		this.loan = false;//setLoan(false);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(num, other.num);
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
}












