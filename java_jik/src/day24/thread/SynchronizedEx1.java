package day24.thread;

public class SynchronizedEx1 {

	public static void main(String[] args) throws InterruptedException {
		Passbook pb = new Passbook();
		User user1 = new User("Hong gil dong", pb);
		User user2 = new User("Hong ga", pb);
		user1.start();
		user2.start();

	}

}
