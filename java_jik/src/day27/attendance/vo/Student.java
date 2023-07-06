package day27.attendance.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Student implements Serializable {

	private static final long serialVersionUID = 107837677974301860L;
	private String num; //학번
	private String name; //이름
	
	//학번, 이름을 이용한 생성자
	public Student(String num, String name) {
		this.num = num;
		this.name = name;
	}
	//복사생성자
	public Student(Student tmp) {
		this(tmp.num, tmp.name);
	}
	//학번으로만 객체가 같은지 판별
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(num, other.num);
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	@Override
	public String toString() {
		return num + " " + name;
	}
	
	
	
}





