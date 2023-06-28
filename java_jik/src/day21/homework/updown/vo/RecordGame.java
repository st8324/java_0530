package day21.homework.updown.vo;

import lombok.Data;

@Data
//sort에 null을 넣어도 가능하게 하기 위해 Comparable을 구현한 구현클래스로 만듬.
public class RecordGame implements Comparable<RecordGame> {

	private String id;
	private int count;
	
	public RecordGame(String id, int count) {
		this.id = id;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "[" + id + " : " + count + "]";
	}

	public int compare(RecordGame o1, RecordGame o2) {
		return o1.getCount()- o2.getCount();
	}

	@Override
	public int compareTo(RecordGame o) {
		// TODO Auto-generated method stub
		return count - o.getCount();
	}
}
