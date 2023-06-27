package day20.homework.vocabularynote.vo;

import java.util.ArrayList;
import java.util.Objects;

import lombok.Data;

@Data
public class Word{
	//멤버 변수
	private String title;
	private ArrayList<String> meanings;
	
	//생성자
	public Word(String title, String meaning) {
		this(title);
		meanings.add(meaning);
	}
	public Word(String title) {
		this.title = title;
		meanings = new ArrayList<>();
	}
	public Word(Word w) {
		this.title = w.title;
		this.meanings = (ArrayList<String>) w.meanings.clone();
	}
	//메서드
	/**단어와 뜻을 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print
	 */
	public void print() {
		System.out.println("word : " + title);
		System.out.println("meaning : ");
		for(int i = 0; i< meanings.size(); i++) {
			System.out.println(i+1+". " + meanings.get(i));
		}
	}
	/**뜻을 추가하는 메서드
	 * 매개변수 : 추가될 뜻 => String meaning
	 * 리턴타입 : 없음 => void
	 * 메서드명 : addMeaning
	 */
	public void addMeaning(String meaning) {
		//다 차는 경우가 없음
		this.meanings.add(meaning);
	}
	/**뜻을 제거하고 제거 여부를 알려주는 메서드
	 * 매개변수 : 제거할 뜻의 번호 => int num
	 * 리턴타입 : 제거 여부 => boolean
	 * 메서드명 : removeMeaning
	 */
	public boolean removeMeaning(int num) {
		if(num > meanings.size() || num < 1) {
			//System.out.println("I can't work.");
			return false;
		}
		meanings.remove(num-1);
		return true;
	}
	/**수정할 뜻의 번호와 수정할 뜻이 주어지면 뜻을 수정하고 수정 여부를 알려주는 메서드
	 * 매개변수 : 수정할 뜻의 번호, 수정할 뜻 => int meaningNum, String meaning 
	 * 리턴타입 : 수정 여부 => boolean
	 * 메서드명 : updateMeaning
	 * @param meaningNum
	 * @param meaning2
	 * @return
	 */
	public boolean updateMeaning(int meaningNum, String meaning) {
		//수정할 뜻의 번호가 잘못된 경우 
		if(meaningNum > meanings.size() || meaningNum <= 0) {
			return false;
		}
		//meaningNum는 1부터이고 번지는 0부터이기 때문에 빼기 1을 한다
		meanings.remove(meaningNum-1);
		meanings.add(meaning);
		return true;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(title, other.title);
	}
	@Override
	public int hashCode() {
		return Objects.hash(title);
	}
	
}













