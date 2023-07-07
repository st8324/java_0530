package day28.baseballgame.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Record implements Serializable {

	private static final long serialVersionUID = -7901828016297450303L;
	private String name;
	private int count;
	@Override
	public String toString() {
		return "[" + name + " : " + count + "]";
	}
	
	
}
