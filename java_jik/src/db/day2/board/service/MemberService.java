package db.day2.board.service;

public interface MemberService {

	boolean signup(String id, String pw);

	boolean withdraw(String id, String pw);

}
