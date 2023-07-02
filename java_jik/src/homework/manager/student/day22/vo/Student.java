package homework.manager.student.day22.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Student {
	//모든 학생들에게 있는 공통적인 속성(대학생, 초,중,고등학생 포함)
	@Getter@Setter
	private String name;//이름
	
	@Getter //주민번호도 Setter를 직접 구현
	private String residentNumber;//주민번호
	
	@Getter //생일 Setter는 아래에서 구현할거라 Getter만 추가
	private Date birthday;
	
	@Getter //나이는 생일을 이용해서 계산해야 되기 때문에 Setter는 필요 없음
	private int age;
	
	public void setResidentNumber(String residentNumber) {
		//주민번호 패턴이 맞는지 확인
		String regex = "^\\d{2}(0\\d|10|11|12)(1\\d|0\\d|2\\d|30|31)-(1|2|3|4)\\d{6}$";
		if(!Pattern.matches(regex, residentNumber)) {
			return;
		}
		//주민번호를 -를 기준으로 나눔
		String arr[] = residentNumber.split("-");
		String birthday = "";
		int gender = Integer.parseInt(arr[1].charAt(0)+"");
		//성별이 1,2이면 1900년대, 3,4이면 2000년대생
		switch (gender) {
		case 1,2:
			birthday = "19" + arr[0];
			break;
		case 3,4:
			birthday = "20" + arr[0];
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			setBirthday(format.parse(birthday));
		} catch (ParseException e) {
			return;
		}
		
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		this.age = calculateAge(birthday);
	}
	//생일이 주어지면 현재 날짜를 기준으로 나이 계산. 만 나이. 바뀐 만나이 계산법으로.
	private int calculateAge(Date birtday) {
		if(birtday == null) {
			return -1;
		}
		//생일을 달력으로 변환(날짜 비교를 편하게 하기 위해)
		Calendar myCal = Calendar.getInstance();
		myCal.setTime(birthday);
		
		Calendar cal = Calendar.getInstance();//현재 시간을 달력으로 변환
		
		//생일에 대한 년, 월, 일을 가져옴
		int myYear = myCal.get(Calendar.YEAR), myMonth = myCal.get(Calendar.MONTH), myDay = myCal.get(Calendar.DAY_OF_MONTH);
		//현재 시간에 대한 년, 월, 일을 가져옴
		int year = cal.get(Calendar.YEAR), month = cal.get(Calendar.MONTH), day = cal.get(Calendar.DAY_OF_MONTH);
		//생일이 안 지난 경우. 현재 달보다 내생일의 달이 뒤이거나 달은 같지만 일이 안지난 경우
		if(myMonth > month || (myMonth == month && myDay > day)) {
			return year - myYear - 1;
		}
		
		//생일이 지난 경우
		return year - myYear;
	}

	public Student(String name, String residentNumber) {
		this.name = name;
		//주민번호로 생일, 나이까지 계산히기 위해 setter를 호출
		setResidentNumber(residentNumber);
	}
	
}
