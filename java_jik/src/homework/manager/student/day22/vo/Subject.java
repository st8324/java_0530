package homework.manager.student.day22.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Subject {
	private String subjectName;//과목명
	private int grade;//학년
	private int semester;//학기
	private double midtermExam;//중간고사
	private double fialExam;//기말고사
	private double performance;//수행평가
	private double total;//총점
	
	private final double midtermExamRatio;
	private final double finalExamRatio;
	private final double performanceRatio;
	
	
	
	public Subject(String subjectName, int grade, int semester) {
		this(subjectName, grade, semester, 0.4, 0.5, 0.1);
	}

	public Subject(String subjectName, int grade, int semester, double midtermExamRatio, double finalExamRatio,
			double performanceRatio) {
		
		this.subjectName = subjectName;
		this.grade = grade;
		this.semester = semester;
		if(midtermExamRatio+finalExamRatio+performanceRatio > 1.0) {
			midtermExamRatio = 0.4;
			finalExamRatio = 0.5;
			performanceRatio = 0.1;
		}
		this.midtermExamRatio = midtermExamRatio;
		this.finalExamRatio = finalExamRatio;
		this.performanceRatio = performanceRatio;
	}
	
	private double checkPoint(double point) {
		if(point > 100 || point < 0) {
			throw new RuntimeException("It's not the right form of scores.");
		}
		return point;
	}
	private void calculateTotal() {
		total = midtermExam * midtermExamRatio + fialExam + finalExamRatio + performance * performanceRatio;
	}
	public void setMidtermExam(double midtermExam) {
		this.midtermExam = checkPoint(midtermExam);
		calculateTotal();
	}
	public void setFinalExam(double finalExam) {
		this.fialExam = checkPoint(finalExam);
		calculateTotal();
	}
	public void setPerformance(double performance) {
		this.performance = checkPoint(performance);
		calculateTotal();
	}
}
