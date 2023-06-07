package day5.homework;

import java.util.Scanner;

public class TeamLeaderEx {

	public static void main(String[] args) {
		/* 30명의 학생이 있는 반에서 1번부터 연속된 번호를 가진 3명의 학생이 1조가 되도록 나누었다. 
		 * 이 때 가장 큰 번호인 학생이 조장이 된다.
		 * 학생 번호가 주어졌을 때 조장인지 조원인지 판별하는 코드를 작성하세요.
		 * */
		int num;
		Scanner sc = new Scanner(System.in);
		//학생 번호를 입력
		System.out.println("input student number : ");
		num = sc.nextInt();
		
		//학생 번호가 팀장번호인지 아닌지를 판별
		//번호가 3의 배수이면 팀장이라고 출력하고 아니면 팀원이라고 출력
		//num를 3으로 나누었을 때 나머지가 0과 같다면 팀장, 아니면 팀원으로 출력
		//num % 3 == 0
		switch(num % 3) {
		case 0:
			System.out.println("Student number " + num + " is the team leader.");
			break;
		default:
			System.out.println("Student number " + num + " is a member of the team.");
		}
		sc.close();
	}

}
