package day20.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private int grade, classNum, num;
	private String name;
}
