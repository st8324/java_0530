package day20.homework.vocabularynote.vo;

import java.util.ArrayList;

/* 단어장 클래스
 * - 단어들의 모임
 * - Word들의 모임
 * */
public class VocabularyNote {
	//멤버 변수
	//단어들
	private ArrayList<Word> wordList;//단어들
	
	//생성자
	public VocabularyNote() {
		wordList = new ArrayList<>();
	}
	
	public VocabularyNote(ArrayList<Word> wordList) {
		this.wordList = (ArrayList<Word>) wordList.clone();
	}
	//메서드
	/**단어들을 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print
	 * */
	public void print() {
		System.out.println("======================");
		for(Word tmp : wordList) {
			tmp.print();
			System.out.println("======================");
		}
	}
	/**단어가 주어지면 단어장에 추가하는 메서드(단어 객체를 넘겨주는 경우)
	 * 매개변수 : 단어(단어 객체) => Word word
	 * 리턴타입 : 없음 => void
	 * 메서드명 : insert
	 */
	public void insert(Word word) {
		//깊은 복사를 위해 Word의 복사 생성자를 이용하여 새 단어를 생성한 후 추가
		wordList.add(new Word(word));
	}
	
	/**단어와 뜻이 주어지면 없는 단어이면 새로 단어를 추가하고 true을 리턴,
	 * 있는 단어이면 뜻만 새로 추가하는 false을 리턴
	 * 매개변수 : 단어와 뜻 => String title, String meaning 
	 * 리턴타입 : 단어추가하면 true, 뜻 추가하면 false
	 * 메서드명 : insert
	 */
	public boolean insert(String title, String meaning) {
		int index = wordList.indexOf(new Word(title));
		//없는 단어이면 새 단어로 추가
		if(index == -1) {
			//단어와 뜻을 이용해 단어 객체를 생성한 후 단어장에 추가
			wordList.add(new Word(title, meaning));
			return true;
		}
		//있는 단어이면 뜻을 추가.
		wordList.get(index).addMeaning(meaning);
		return false;
	}
	/**단어가 주어지면 단어장에서 삭제하고 삭제 여부를 알려주는 메서드
	 * 매개변수 : 삭제할 단어 => String title
	 * 리턴타입 : 삭제여부 => boolean
	 * 메서드명 : delete
	 */
	public boolean delete(String title) {
		if(!wordList.remove(new Word(title))) {
			return false;
		}
		return true;
	}
	
	
	/**단어가 주어지면 단어장에 해당 단어를 출력하고 단어가 있는지 없는지를 알려주는
	 * 메서드
	 * 매개변수 : 단어 => String title
	 * 리턴타입 : 단어가 있는지 없는지 => boolean
	 * 메서드명 : search
	 */
	public boolean search(String title) {
		int index = wordList.indexOf(new Word(title));
		
		if(index == -1) {
			return false;
		}
		
		wordList.get(index).print();
		return true;
	}
	
	/**단어와 수정할 뜻의 번호와 수정할 뜻이 주어지면 단어의 뜻을 수정하고
	 * 수정 여부를 알려주는 메서드
	 * 매개변수 : 단어, 수정할 뜻 번호, 수정할 뜻
	 * 		=> String title, int meaningIndex, String meaning
	 * 리턴타입 : 수정여부 => boolean
	 * 메서드명 : updateMeaing
	 */
	public boolean updateMeaning(String title, int meaningIndex, String meaning) {

		int index = wordList.indexOf(new Word(title));
		
		if(index == -1) {
			return false; 
		}
		
		if(!wordList.get(index).updateMeaning(meaningIndex, meaning)) {
			//System.out.println("Wrong number");
			return false;
		}
		return true;
	}
	
	/**단어와 수정할 단어가 단어가 주어지면 단어를 수정하고 수정 여부를 알려주는 메서드
	 * 매개변수 : 단어와 수정할 단어 => String title, String updateTitle
	 * 리턴타입 : 수정 여부 => boolean
	 * 메서드명 : updateTitle
	 */
	public boolean updateTitle(String title, String updateTitle) {
		int index = wordList.indexOf(new Word(title));
		
		if(index == -1) {
			//System.out.println("No words found");
			return false; 
		}
		
		wordList.get(index).setTitle(updateTitle);
		return true;
	}

	/**단어와 삭제할 뜻의 번호가 주어지면 뜻을 삭제하고, 삭제 여부를 알려주는
	 * 메서드
	 * 매개변수 : 단어와 뜻 번호 => String title, int num
	 * 리턴타입 : 뜻 삭제 여부 => boolean
	 * 메서드명 : deleteMeaning
	 */
	public boolean deleteMeaning(String title, int num) {
		//단어의 위치를 찾음
		int index = wordList.indexOf(new Word(title));
		//단어가 없으면 삭제 못함
		if(index == -1) {
			return false;
		}
		Word tmp = wordList.get(index);
		if(tmp.removeMeaning(num)) {
			return true;
		}
		return false;
	}
}







