package homework.manager.student.day22.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class HighSchoolStudent extends Student {

	private int grade, classNum, num;//현재 학년, 반, 번호 
	
	List<Subject> list = new ArrayList<>();//과목 정보
	
	String state;//재학, 휴학, 자퇴, 퇴학, 졸업
	
	String etc;//전학옴, 전학감
	
	public HighSchoolStudent(String name, String residentNumber, int grade, int classNum, int num) {
		super(name, residentNumber);
	}

}
