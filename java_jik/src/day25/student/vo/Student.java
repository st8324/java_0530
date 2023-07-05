package day25.student.vo;

import java.io.Serializable;

public class Student implements Serializable {

	
	private static final long serialVersionUID = -1534984605875676285L;
	
	private String num, name, major;

	public Student(String num, String name, String major) {
		this.num = num;
		this.name = name;
		this.major = major;
	}
	

	@Override
	public String toString() {
		return "학번 : " + num + "\n이름 : " + name + "\n전공 : " + major;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
